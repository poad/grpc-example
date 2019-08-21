#[macro_use]
extern crate serde_derive;
extern crate futures;
extern crate grpcio;
extern crate protobuf;

pub mod hello;
pub mod hello_grpc;

pub mod message;
pub mod message_grpc;

#[derive(Debug, Deserialize)]
pub struct Hello {
    name: String,
}

#[derive(Debug, Serialize)]
pub struct HelloResponse {
    message: String,
}

#[derive(Debug, Serialize, Deserialize)]
pub struct Message {
    id: Option<String>,
    message: String,
}

pub mod handlers {
    use crate::hello::HelloRequest;
    use crate::hello_grpc::GreeterClient;
    use crate::message::{
        DeleteMessageRequest, DeleteMessagesRequest, GenerateUUIDRequest, GetMessageRequest,
        GetMessagesRequest, MessageEntity, UUIDEntity,
    };
    use crate::message_grpc::{MessengerClient, UuidGeneratorClient};
    use crate::{Hello, HelloResponse, Message};
    use actix_web::{web, HttpResponse, Responder};
    use grpcio::{ChannelBuilder, EnvBuilder};
    use std::borrow::Borrow;
    use std::env;
    use std::sync::Arc;

    pub fn hello(req: web::Query<Hello>) -> impl Responder {
        let env = Arc::new(EnvBuilder::new().build());
        let host = env::var("HELLO_GRPC_ENDPOINT").unwrap_or("127.0.0.1".to_owned());
        let ch = ChannelBuilder::new(env).connect(format!("{}:{}", host, 50050).as_str());
        let client = GreeterClient::new(ch);
        let mut request = HelloRequest::new();
        request.set_name((&req).name.to_string());
        let result = client.say_hello(&request);
        let message = result
            .expect("Failed to gRPC call")
            .get_message()
            .to_string();
        HttpResponse::Ok()
            .body(serde_json::to_string(&HelloResponse { message }).expect("serialize failed"))
    }

    pub fn get_massage(req: web::Path<(String,)>) -> impl Responder {
        let env = Arc::new(EnvBuilder::new().build());
        let host = env::var("GRPC_ENDPOINT").unwrap_or("127.0.0.1".to_owned());
        let ch = ChannelBuilder::new(env).connect(format!("{}:{}", host, 50051).as_str());
        let client = MessengerClient::new(ch);
        let mut request = GetMessageRequest::new();
        let mut id = UUIDEntity::new();
        id.set_value(req.0.to_string());
        request.set_id(id);
        let message = client
            .get_message(request.borrow())
            .expect("Failed to gRPC call")
            .get_message()
            .to_string();
        HttpResponse::Ok().body(
            serde_json::to_string(&Message {
                id: Some(req.0.clone()),
                message,
            })
            .expect("serialize failed"),
        )
    }

    pub fn get_massages() -> impl Responder {
        let env = Arc::new(EnvBuilder::new().build());
        let host = env::var("GRPC_ENDPOINT").unwrap_or("127.0.0.1".to_owned());
        let ch = ChannelBuilder::new(env).connect(format!("{}:{}", host, 50051).as_str());
        let client = MessengerClient::new(ch);
        let request = GetMessagesRequest::new();
        let result = client.list_messages(&request);
        let messages = result
            .expect("Failed to gRPC call")
            .get_messages()
            .iter()
            .map(|m| Message {
                id: Some((&m).get_id().get_value().to_string()),
                message: (&m).get_message().to_string(),
            })
            .collect::<Vec<Message>>();
        HttpResponse::Ok().body(serde_json::to_string(&messages).expect("serialize failed"))
    }

    pub fn create_message(req: web::Json<Message>) -> impl Responder {
        let env = Arc::new(EnvBuilder::new().build());
        let host = env::var("UUID_GRPC_ENDPOINT").unwrap_or("127.0.0.1".to_owned());
        let uuid_ch = ChannelBuilder::new(env).connect(format!("{}:{}", host, 50052).as_str());
        let uuid_client = UuidGeneratorClient::new(uuid_ch);
        let id = uuid_client
            .generate_uuid(&GenerateUUIDRequest::new())
            .expect("generate uuid failed");

        let env = Arc::new(EnvBuilder::new().build());
        let host = env::var("GRPC_ENDPOINT").unwrap_or("127.0.0.1".to_owned());
        let ch = ChannelBuilder::new(env).connect(format!("{}:{}", host, 50051).as_str());
        let client = MessengerClient::new(ch);

        let mut request = MessageEntity::new();
        let message = &req.message;

        request.set_id(id.borrow().to_owned());
        request.set_message(message.to_string());
        let message = client
            .put_message(request.borrow())
            .expect("Failed to gRPC call")
            .get_message()
            .to_string();
        HttpResponse::Ok().body(
            serde_json::to_string(&Message {
                id: Some(id.get_value().parse().unwrap()),
                message,
            })
            .expect("serialize failed"),
        )
    }

    pub fn update_message(req: web::Json<Message>, path: web::Path<(String,)>) -> impl Responder {
        let env = Arc::new(EnvBuilder::new().build());
        let host = env::var("GRPC_ENDPOINT").unwrap_or("127.0.0.1".to_owned());
        let ch = ChannelBuilder::new(env).connect(format!("{}:{}", host, 50051).as_str());
        let client = MessengerClient::new(ch);

        let mut request = MessageEntity::new();
        let message = &req.message;
        let mut id = UUIDEntity::new();
        id.set_value(path.0.to_string());

        request.set_id(id.borrow().to_owned());
        request.set_message(message.to_string());
        let message = client
            .put_message(request.borrow())
            .expect("Failed to gRPC call")
            .get_message()
            .to_string();

        HttpResponse::Ok().body(
            serde_json::to_string(&Message {
                id: Some(id.get_value().parse().unwrap()),
                message,
            })
            .expect("serialize failed"),
        )
    }

    pub fn delete_message(req: web::Path<(String,)>) -> impl Responder {
        let env = Arc::new(EnvBuilder::new().build());
        let host = env::var("GRPC_ENDPOINT").unwrap_or("127.0.0.1".to_owned());
        let ch = ChannelBuilder::new(env).connect(format!("{}:{}", host, 50051).as_str());
        let client = MessengerClient::new(ch);

        let mut request = DeleteMessageRequest::new();
        let mut id = UUIDEntity::new();
        id.set_value(req.0.to_string());
        request.set_id(id);
        let message = client
            .delete_message(request.borrow())
            .expect("Failed to gRPC call");

        HttpResponse::Ok().body(
            serde_json::to_string(&Message {
                id: Some((&message.get_id().get_value()).to_string()),
                message: message.get_message().to_string(),
            })
            .expect("serialize failed"),
        )
    }

    pub fn delete_messages() -> impl Responder {
        let env = Arc::new(EnvBuilder::new().build());
        let host = env::var("GRPC_ENDPOINT").unwrap_or("127.0.0.1".to_owned());
        let ch = ChannelBuilder::new(env).connect(format!("{}:{}", host, 50051).as_str());
        let client = MessengerClient::new(ch);

        let request = DeleteMessagesRequest::new();
        client
            .delete_messages(request.borrow())
            .expect("Failed to gRPC call");

        HttpResponse::Ok().finish()
    }

}
