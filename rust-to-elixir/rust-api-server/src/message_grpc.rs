// This file is generated. Do not edit
// @generated

// https://github.com/Manishearth/rust-clippy/issues/702
#![allow(unknown_lints)]
#![allow(clippy::all)]

#![cfg_attr(rustfmt, rustfmt_skip)]

#![allow(box_pointers)]
#![allow(dead_code)]
#![allow(missing_docs)]
#![allow(non_camel_case_types)]
#![allow(non_snake_case)]
#![allow(non_upper_case_globals)]
#![allow(trivial_casts)]
#![allow(unsafe_code)]
#![allow(unused_imports)]
#![allow(unused_results)]

const METHOD_UUID_GENERATOR_GENERATE_UUID: ::grpcio::Method<super::message::GenerateUUIDRequest, super::message::UUIDEntity> = ::grpcio::Method {
    ty: ::grpcio::MethodType::Unary,
    name: "/message.UUIDGenerator/GenerateUUID",
    req_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
    resp_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
};

#[derive(Clone)]
pub struct UuidGeneratorClient {
    client: ::grpcio::Client,
}

impl UuidGeneratorClient {
    pub fn new(channel: ::grpcio::Channel) -> Self {
        UuidGeneratorClient {
            client: ::grpcio::Client::new(channel),
        }
    }

    pub fn generate_uuid_opt(&self, req: &super::message::GenerateUUIDRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<super::message::UUIDEntity> {
        self.client.unary_call(&METHOD_UUID_GENERATOR_GENERATE_UUID, req, opt)
    }

    pub fn generate_uuid(&self, req: &super::message::GenerateUUIDRequest) -> ::grpcio::Result<super::message::UUIDEntity> {
        self.generate_uuid_opt(req, ::grpcio::CallOption::default())
    }

    pub fn generate_uuid_async_opt(&self, req: &super::message::GenerateUUIDRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::UUIDEntity>> {
        self.client.unary_call_async(&METHOD_UUID_GENERATOR_GENERATE_UUID, req, opt)
    }

    pub fn generate_uuid_async(&self, req: &super::message::GenerateUUIDRequest) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::UUIDEntity>> {
        self.generate_uuid_async_opt(req, ::grpcio::CallOption::default())
    }
    pub fn spawn<F>(&self, f: F) where F: ::futures::Future<Output = ()> + Send + 'static {
        self.client.spawn(f)
    }
}

pub trait UuidGenerator {
    fn generate_uuid(&mut self, ctx: ::grpcio::RpcContext, req: super::message::GenerateUUIDRequest, sink: ::grpcio::UnarySink<super::message::UUIDEntity>);
}

pub fn create_uuid_generator<S: UuidGenerator + Send + Clone + 'static>(s: S) -> ::grpcio::Service {
    let mut builder = ::grpcio::ServiceBuilder::new();
    let mut instance = s;
    builder = builder.add_unary_handler(&METHOD_UUID_GENERATOR_GENERATE_UUID, move |ctx, req, resp| {
        instance.generate_uuid(ctx, req, resp)
    });
    builder.build()
}

const METHOD_MESSENGER_GET_MESSAGE: ::grpcio::Method<super::message::GetMessageRequest, super::message::MessageEntity> = ::grpcio::Method {
    ty: ::grpcio::MethodType::Unary,
    name: "/message.Messenger/GetMessage",
    req_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
    resp_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
};

const METHOD_MESSENGER_LIST_MESSAGES: ::grpcio::Method<super::message::GetMessagesRequest, super::message::MessagesResponse> = ::grpcio::Method {
    ty: ::grpcio::MethodType::Unary,
    name: "/message.Messenger/ListMessages",
    req_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
    resp_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
};

const METHOD_MESSENGER_PUT_MESSAGE: ::grpcio::Method<super::message::MessageEntity, super::message::MessageEntity> = ::grpcio::Method {
    ty: ::grpcio::MethodType::Unary,
    name: "/message.Messenger/PutMessage",
    req_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
    resp_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
};

const METHOD_MESSENGER_DELETE_MESSAGE: ::grpcio::Method<super::message::DeleteMessageRequest, super::message::MessageEntity> = ::grpcio::Method {
    ty: ::grpcio::MethodType::Unary,
    name: "/message.Messenger/DeleteMessage",
    req_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
    resp_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
};

const METHOD_MESSENGER_DELETE_MESSAGES: ::grpcio::Method<super::message::DeleteMessagesRequest, super::message::DeleteMessagesResponse> = ::grpcio::Method {
    ty: ::grpcio::MethodType::Unary,
    name: "/message.Messenger/DeleteMessages",
    req_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
    resp_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
};

const METHOD_MESSENGER_COUNT_MESSAGES: ::grpcio::Method<super::message::CountMessagesRequest, super::message::MessageCount> = ::grpcio::Method {
    ty: ::grpcio::MethodType::Unary,
    name: "/message.Messenger/CountMessages",
    req_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
    resp_mar: ::grpcio::Marshaller { ser: ::grpcio::pb_ser, de: ::grpcio::pb_de },
};

#[derive(Clone)]
pub struct MessengerClient {
    client: ::grpcio::Client,
}

impl MessengerClient {
    pub fn new(channel: ::grpcio::Channel) -> Self {
        MessengerClient {
            client: ::grpcio::Client::new(channel),
        }
    }

    pub fn get_message_opt(&self, req: &super::message::GetMessageRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<super::message::MessageEntity> {
        self.client.unary_call(&METHOD_MESSENGER_GET_MESSAGE, req, opt)
    }

    pub fn get_message(&self, req: &super::message::GetMessageRequest) -> ::grpcio::Result<super::message::MessageEntity> {
        self.get_message_opt(req, ::grpcio::CallOption::default())
    }

    pub fn get_message_async_opt(&self, req: &super::message::GetMessageRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessageEntity>> {
        self.client.unary_call_async(&METHOD_MESSENGER_GET_MESSAGE, req, opt)
    }

    pub fn get_message_async(&self, req: &super::message::GetMessageRequest) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessageEntity>> {
        self.get_message_async_opt(req, ::grpcio::CallOption::default())
    }

    pub fn list_messages_opt(&self, req: &super::message::GetMessagesRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<super::message::MessagesResponse> {
        self.client.unary_call(&METHOD_MESSENGER_LIST_MESSAGES, req, opt)
    }

    pub fn list_messages(&self, req: &super::message::GetMessagesRequest) -> ::grpcio::Result<super::message::MessagesResponse> {
        self.list_messages_opt(req, ::grpcio::CallOption::default())
    }

    pub fn list_messages_async_opt(&self, req: &super::message::GetMessagesRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessagesResponse>> {
        self.client.unary_call_async(&METHOD_MESSENGER_LIST_MESSAGES, req, opt)
    }

    pub fn list_messages_async(&self, req: &super::message::GetMessagesRequest) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessagesResponse>> {
        self.list_messages_async_opt(req, ::grpcio::CallOption::default())
    }

    pub fn put_message_opt(&self, req: &super::message::MessageEntity, opt: ::grpcio::CallOption) -> ::grpcio::Result<super::message::MessageEntity> {
        self.client.unary_call(&METHOD_MESSENGER_PUT_MESSAGE, req, opt)
    }

    pub fn put_message(&self, req: &super::message::MessageEntity) -> ::grpcio::Result<super::message::MessageEntity> {
        self.put_message_opt(req, ::grpcio::CallOption::default())
    }

    pub fn put_message_async_opt(&self, req: &super::message::MessageEntity, opt: ::grpcio::CallOption) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessageEntity>> {
        self.client.unary_call_async(&METHOD_MESSENGER_PUT_MESSAGE, req, opt)
    }

    pub fn put_message_async(&self, req: &super::message::MessageEntity) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessageEntity>> {
        self.put_message_async_opt(req, ::grpcio::CallOption::default())
    }

    pub fn delete_message_opt(&self, req: &super::message::DeleteMessageRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<super::message::MessageEntity> {
        self.client.unary_call(&METHOD_MESSENGER_DELETE_MESSAGE, req, opt)
    }

    pub fn delete_message(&self, req: &super::message::DeleteMessageRequest) -> ::grpcio::Result<super::message::MessageEntity> {
        self.delete_message_opt(req, ::grpcio::CallOption::default())
    }

    pub fn delete_message_async_opt(&self, req: &super::message::DeleteMessageRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessageEntity>> {
        self.client.unary_call_async(&METHOD_MESSENGER_DELETE_MESSAGE, req, opt)
    }

    pub fn delete_message_async(&self, req: &super::message::DeleteMessageRequest) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessageEntity>> {
        self.delete_message_async_opt(req, ::grpcio::CallOption::default())
    }

    pub fn delete_messages_opt(&self, req: &super::message::DeleteMessagesRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<super::message::DeleteMessagesResponse> {
        self.client.unary_call(&METHOD_MESSENGER_DELETE_MESSAGES, req, opt)
    }

    pub fn delete_messages(&self, req: &super::message::DeleteMessagesRequest) -> ::grpcio::Result<super::message::DeleteMessagesResponse> {
        self.delete_messages_opt(req, ::grpcio::CallOption::default())
    }

    pub fn delete_messages_async_opt(&self, req: &super::message::DeleteMessagesRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::DeleteMessagesResponse>> {
        self.client.unary_call_async(&METHOD_MESSENGER_DELETE_MESSAGES, req, opt)
    }

    pub fn delete_messages_async(&self, req: &super::message::DeleteMessagesRequest) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::DeleteMessagesResponse>> {
        self.delete_messages_async_opt(req, ::grpcio::CallOption::default())
    }

    pub fn count_messages_opt(&self, req: &super::message::CountMessagesRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<super::message::MessageCount> {
        self.client.unary_call(&METHOD_MESSENGER_COUNT_MESSAGES, req, opt)
    }

    pub fn count_messages(&self, req: &super::message::CountMessagesRequest) -> ::grpcio::Result<super::message::MessageCount> {
        self.count_messages_opt(req, ::grpcio::CallOption::default())
    }

    pub fn count_messages_async_opt(&self, req: &super::message::CountMessagesRequest, opt: ::grpcio::CallOption) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessageCount>> {
        self.client.unary_call_async(&METHOD_MESSENGER_COUNT_MESSAGES, req, opt)
    }

    pub fn count_messages_async(&self, req: &super::message::CountMessagesRequest) -> ::grpcio::Result<::grpcio::ClientUnaryReceiver<super::message::MessageCount>> {
        self.count_messages_async_opt(req, ::grpcio::CallOption::default())
    }
    pub fn spawn<F>(&self, f: F) where F: ::futures::Future<Output = ()> + Send + 'static {
        self.client.spawn(f)
    }
}

pub trait Messenger {
    fn get_message(&mut self, ctx: ::grpcio::RpcContext, req: super::message::GetMessageRequest, sink: ::grpcio::UnarySink<super::message::MessageEntity>);
    fn list_messages(&mut self, ctx: ::grpcio::RpcContext, req: super::message::GetMessagesRequest, sink: ::grpcio::UnarySink<super::message::MessagesResponse>);
    fn put_message(&mut self, ctx: ::grpcio::RpcContext, req: super::message::MessageEntity, sink: ::grpcio::UnarySink<super::message::MessageEntity>);
    fn delete_message(&mut self, ctx: ::grpcio::RpcContext, req: super::message::DeleteMessageRequest, sink: ::grpcio::UnarySink<super::message::MessageEntity>);
    fn delete_messages(&mut self, ctx: ::grpcio::RpcContext, req: super::message::DeleteMessagesRequest, sink: ::grpcio::UnarySink<super::message::DeleteMessagesResponse>);
    fn count_messages(&mut self, ctx: ::grpcio::RpcContext, req: super::message::CountMessagesRequest, sink: ::grpcio::UnarySink<super::message::MessageCount>);
}

pub fn create_messenger<S: Messenger + Send + Clone + 'static>(s: S) -> ::grpcio::Service {
    let mut builder = ::grpcio::ServiceBuilder::new();
    let mut instance = s.clone();
    builder = builder.add_unary_handler(&METHOD_MESSENGER_GET_MESSAGE, move |ctx, req, resp| {
        instance.get_message(ctx, req, resp)
    });
    let mut instance = s.clone();
    builder = builder.add_unary_handler(&METHOD_MESSENGER_LIST_MESSAGES, move |ctx, req, resp| {
        instance.list_messages(ctx, req, resp)
    });
    let mut instance = s.clone();
    builder = builder.add_unary_handler(&METHOD_MESSENGER_PUT_MESSAGE, move |ctx, req, resp| {
        instance.put_message(ctx, req, resp)
    });
    let mut instance = s.clone();
    builder = builder.add_unary_handler(&METHOD_MESSENGER_DELETE_MESSAGE, move |ctx, req, resp| {
        instance.delete_message(ctx, req, resp)
    });
    let mut instance = s.clone();
    builder = builder.add_unary_handler(&METHOD_MESSENGER_DELETE_MESSAGES, move |ctx, req, resp| {
        instance.delete_messages(ctx, req, resp)
    });
    let mut instance = s;
    builder = builder.add_unary_handler(&METHOD_MESSENGER_COUNT_MESSAGES, move |ctx, req, resp| {
        instance.count_messages(ctx, req, resp)
    });
    builder.build()
}
