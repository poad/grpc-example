extern crate log;
extern crate env_logger;
extern crate rust_grpc_server;
extern crate diesel;
extern crate ctrlc;

mod hello;
mod message;

use log::info;

use tonic::{transport::Server, Request, Response, Status};

use crate::hello::{greeter_server::*, *};
use crate::message::{uuid_generator_server::*, messenger_server::*, *};

use self::rust_grpc_server::*;

#[derive(Default)]
struct GreeterService;

#[derive(Default)]
struct UuidService;

#[derive(Default)]
struct MessagerService;

#[tonic::async_trait]
impl Greeter for GreeterService {
    async fn say_hello(
            &self,
            request: Request<HelloRequest>,
        ) -> Result<Response<HelloReply>, Status> {
        let msg = format!("Hello {}", request.get_ref().name);
        let reply = HelloReply{
            message: msg.clone()
        };

        Ok(Response::new(reply))
    }
}

#[tonic::async_trait]
impl UuidGenerator for UuidService {
    async fn generate_uuid(
            &self,
            _request: Request<GenerateUuidRequest>,
        ) -> Result<Response<UuidEntity>, Status> {

        let mut connection = establish_connection();
        info!("connected to database");

        let reply = UuidEntity{
            value: generate_uuid(&connection)
        };

        Ok(Response::new(reply))
    }
}

#[tonic::async_trait]
impl Messenger for MessagerService {
    async fn get_message(
            &self,
            request: Request<GetMessageRequest>,
        ) -> Result<Response<MessageEntity>, Status> {

        let mut connection = establish_connection();
        info!("connected to database");

        let uuid = request.get_ref().id.as_ref();
        let id = &(uuid).expect("").value;

        let message = get_message(&connection, &id.as_str());
        let content = message.content;

        let reply = MessageEntity{
            id: Some(UuidEntity{value: id.to_string()}),
            message: content

        };

        Ok(Response::new(reply))
    }

    async fn list_messages(
            &self,
            _request: Request<GetMessagesRequest>,
        ) -> Result<Response<MessagesResponse>, Status> {

        let connection= establish_connection();
        info!("connected to database");

        let reply = MessagesResponse {
        messages:
            list_massages(&connection)
                .iter()
                .map(|message| {
                    let entity = MessageEntity{
                        id: Some(UuidEntity{
                        value: message.id.clone()
                    }),
                        message: message.content.clone()
                    };
                    entity
                })
                .collect()
            };

        Ok(Response::new(reply))
    }

    async fn put_message(
            &self,
            request: Request<MessageEntity>,
        ) -> Result<Response<MessageEntity>, Status> {
        let mut connection = establish_connection();
        info!("connected to database");

        let uuid = request.get_ref().id.as_ref();
        let id = &(uuid).expect("").value;
        let message = request.get_ref().message.as_str();

        let entity = if exists_message(&connection, id) {
            update_message(&connection, id, message)
        } else {
            create_message(&connection, id, message)
        };

        let reply = MessageEntity{
            id: Some(UuidEntity {
                value: entity.id.clone(),
            }),
            message: entity.content.clone()
        };

        Ok(Response::new(reply))
    }

    async fn delete_message(
            &self,
            request: Request<DeleteMessageRequest>,
        ) -> Result<Response<MessageEntity>, Status> {

        let mut connection = establish_connection();
        info!("connected to database");

        let uuid = request.get_ref().id.as_ref();
        let id = &(uuid).expect("").value;

        let entity = get_message(&connection, &id);
        delete_message(&connection, &id);

        let reply = MessageEntity {
            id: Some(UuidEntity {
                value: entity.id.clone()
            }),
            message: entity.content.clone()
        };

        Ok(Response::new(reply))
    }

    async fn delete_messages(
            &self,
            _request: Request<DeleteMessagesRequest>,
        ) -> Result<Response<DeleteMessagesResponse>, Status> {

        let mut connection = establish_connection();
        info!("connected to database");

        delete_messages(&connection);

        Ok(Response::new(DeleteMessagesResponse{}))
    }

    async fn count_messages(
            &self,
            _request: Request<CountMessagesRequest>,
        ) -> Result<Response<MessageCount>, Status> {

        let mut connection = establish_connection();
        info!("connected to database");

        let count = count_massages(&connection);

        let reply = MessageCount{
            count
        };

        Ok(Response::new(reply))
    }
}

#[tokio::main]
async fn main()  -> Result<(), Box<dyn std::error::Error>> {
    let addr = "[::1]:50051".parse().unwrap();

    let greeter_service = tonic_web::config()
        .allow_origins(vec!["127.0.0.1"])
        .enable(GreeterServer::new(GreeterService::default()));

    let message_service = tonic_web::config()
        .allow_origins(vec!["127.0.0.1"])
        .enable(MessengerServer::new(MessagerService::default()));

    env_logger::init();
    Server::builder()
        .add_service(greeter_service)
        .add_service(message_service)
        .serve(addr)
        .await?;

    Ok(())
}
