
#[macro_use]
extern crate log;
extern crate env_logger;
extern crate rust_grpc_server;
extern crate diesel;
extern crate ctrlc;

mod hello;
mod hello_grpc;

mod message;
mod message_grpc;

use protobuf::SingularPtrField;
use std::sync::Arc;

use futures::channel::oneshot;
use futures::{TryFutureExt, FutureExt};
use grpcio::{Environment, RpcContext, ServerBuilder, UnarySink};

use hello_grpc::{Greeter};
use hello::{HelloReply, HelloRequest};

use message_grpc::*;
use message::*;

use self::rust_grpc_server::*;
use futures::channel::oneshot::{Sender, Receiver};
use futures::executor::block_on;

#[derive(Clone)]
struct GreeterService;

#[derive(Clone)]
struct UuidService;

#[derive(Clone)]
struct MessageService;

impl Greeter for GreeterService {
    fn say_hello(&mut self, ctx: RpcContext<'_>, req: HelloRequest, sink: UnarySink<HelloReply>) {
        let msg = format!("Hello {}", req.name);
        let mut resp = HelloReply::new();
        resp.message = msg.clone();

        let f = sink
            .success(resp)
            .map_err(move |e| error!("failed to reply {:?}: {:?}", req, e))
            .map(move |_| println!("Responded {{ {:?} }}", msg));
        ctx.spawn(f);
    }
}

impl UuidGenerator for UuidService {
    fn generate_uuid(&mut self, ctx: RpcContext<'_>, req: GenerateUUIDRequest, sink: UnarySink<UUIDEntity>) {
        let connection = establish_connection();
        info!("connected to database");

        let mut resp = UUIDEntity::new();
        let uuid = generate_uuid(&connection);
        resp.value = uuid.clone();

        let f = sink
            .success(resp)
            .map_err(move |e| error!("failed to reply {:?}: {:?}", req, e))
            .map(move |_| println!("Responded {{ {:?} }}", uuid));
        ctx.spawn(f)
    }
}

impl Messenger for MessageService {
    fn get_message(&mut self, ctx: RpcContext, req: GetMessageRequest, sink: UnarySink<MessageEntity>) {
        let connection = establish_connection();
        info!("connected to database");

        let id = req.get_id();
        let message = get_message(&connection, &id.get_value());

        let mut entity = MessageEntity::new();
        entity.id = SingularPtrField::from(SingularPtrField::some(id.to_owned()));
        entity.message = message.content.clone();

        let f = sink
            .success(entity)
            .map_err(move |e| error!("failed to reply {:?}: {:?}", req, e))
            .map(move |_| println!("Responded {{ {:?} }}", message.content));
        ctx.spawn(f)
    }

    fn list_messages(&mut self, ctx: RpcContext, req: GetMessagesRequest, sink: UnarySink<MessagesResponse>) {
        let connection= establish_connection();
        info!("connected to database");

        let mut resp = MessagesResponse::new();
        resp.messages =
            list_massages(&connection)
                .iter()
                .map(|message| {
                    let mut entity = MessageEntity::new();
                    let mut uuid = UUIDEntity::new();
                    uuid.value = message.id.clone();
                    entity.id = SingularPtrField::from(SingularPtrField::some(uuid));
                    entity.message = message.content.clone();
                    entity
                })
                .collect();
        let f = sink
            .success(resp)
            .map_err(move |e| error!("failed to reply {:?}: {:?}", req, e))
            .map(move |resp| println!("Responded {{ {:?} }}", resp));
        ctx.spawn(f)
    }

    fn put_message(&mut self, ctx: RpcContext, req: MessageEntity, sink: UnarySink<MessageEntity>) {
        let connection = establish_connection();
        info!("connected to database");

        let id = &req.get_id().get_value();
        let message = req.message.as_str();

        let entity = if exists_message(&connection, id) {
            update_message(&connection, id, message)
        } else {
            create_message(&connection, id, message)
        };

        let mut resp = MessageEntity::new();
        let mut uuid = UUIDEntity::new();
        uuid.value = entity.id.clone();
        resp.id = SingularPtrField::from(SingularPtrField::some(uuid));
        resp.message = entity.content.clone();

        let f = sink
            .success(resp)
            .map_err(move |e| error!("failed to reply {:?}: {:?}", req, e))
            .map(move |resp| println!("Responded {{ {:?} }}", resp));
        ctx.spawn(f)
    }

    fn delete_message(&mut self, ctx: RpcContext, req: DeleteMessageRequest, sink: UnarySink<MessageEntity>) {
        let connection = establish_connection();
        info!("connected to database");

        let id = req.get_id();

        let entity = get_message(&connection, &id.get_value());
        delete_message(&connection, &id.get_value());

        let mut resp = MessageEntity::new();
        let mut uuid = UUIDEntity::new();
        uuid.value = entity.id.clone();
        resp.id = SingularPtrField::from(SingularPtrField::some(uuid));
        resp.message = entity.content.clone();

        let f = sink
            .success(resp)
            .map_err(move |e| error!("failed to reply {:?}: {:?}", req, e))
            .map(move |resp| println!("Responded {{ {:?} }}", resp));
        ctx.spawn(f)
    }

    fn delete_messages(&mut self, ctx: RpcContext, req: DeleteMessagesRequest, sink: UnarySink<DeleteMessagesResponse>) {
        let connection = establish_connection();
        info!("connected to database");

        delete_messages(&connection);

        let f = sink
            .success(DeleteMessagesResponse::new())
            .map_err(move |e| error!("failed to reply {:?}: {:?}", req, e))
            .map(move |resp| println!("Responded {{ {:?} }}", resp));
        ctx.spawn(f)
    }

    fn count_messages(&mut self, ctx: RpcContext, req: CountMessagesRequest, sink: UnarySink<MessageCount>) {
        let connection = establish_connection();
        info!("connected to database");

        let count = count_massages(&connection);

        let mut resp = MessageCount::new();
        resp.count = count;

        let f = sink
            .success(resp)
            .map_err(move |e| error!("failed to reply {:?}: {:?}", req, e))
            .map(move |resp| println!("Responded {{ {:?} }}", resp));
        ctx.spawn(f)
    }
}

fn main() {
    let env = Arc::new(Environment::new(1));
    let service = hello_grpc::create_greeter(GreeterService);
    let uuid_service = message_grpc::create_uuid_generator(UuidService);
    let message_service = message_grpc::create_messenger(MessageService);
    let mut server = ServerBuilder::new(env)
        .register_service(service)
        .register_service(uuid_service)
        .register_service(message_service)
        .bind("0.0.0.0", 50_051)
        .build()
        .unwrap();
    env_logger::init();
    server.start();
    for (ref host, port) in server.bind_addrs() {
        info!("listening on {}:{}", host, port);
    }

    let (_tx, rx): (Sender<()>, Receiver<()>) = oneshot::channel();
//    let (tx, rx) = oneshot::channel();
//    thread::spawn(move || {
//        info!("Press ENTER to exit...");
//        let _ = io::stdin().read(&mut [0]).unwrap();
//        tx.send(())
//    });
    let _ = block_on(rx);
    let _ = block_on(server.shutdown());
}
