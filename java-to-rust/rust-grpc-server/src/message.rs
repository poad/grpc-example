#[derive(Clone, PartialEq, ::prost::Message)]
pub struct UuidEntity {
    #[prost(string, tag="1")]
    pub value: ::prost::alloc::string::String,
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct GenerateUuidRequest {
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct MessageEntity {
    #[prost(message, optional, tag="1")]
    pub id: ::core::option::Option<UuidEntity>,
    #[prost(string, tag="2")]
    pub message: ::prost::alloc::string::String,
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct GetMessageRequest {
    #[prost(message, optional, tag="1")]
    pub id: ::core::option::Option<UuidEntity>,
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct GetMessagesRequest {
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct DeleteMessagesRequest {
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct DeleteMessageRequest {
    #[prost(message, optional, tag="1")]
    pub id: ::core::option::Option<UuidEntity>,
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct CountMessagesRequest {
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct MessageCount {
    #[prost(int64, tag="1")]
    pub count: i64,
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct DeleteMessagesResponse {
}
#[derive(Clone, PartialEq, ::prost::Message)]
pub struct MessagesResponse {
    #[prost(message, repeated, tag="1")]
    pub messages: ::prost::alloc::vec::Vec<MessageEntity>,
}
/// Generated server implementations.
pub mod uuid_generator_server {
    #![allow(unused_variables, dead_code, missing_docs, clippy::let_unit_value)]
    use tonic::codegen::*;
    ///Generated trait containing gRPC methods that should be implemented for use with UuidGeneratorServer.
    #[async_trait]
    pub trait UuidGenerator: Send + Sync + 'static {
        async fn generate_uuid(
            &self,
            request: tonic::Request<super::GenerateUuidRequest>,
        ) -> Result<tonic::Response<super::UuidEntity>, tonic::Status>;
    }
    #[derive(Debug)]
    pub struct UuidGeneratorServer<T: UuidGenerator> {
        inner: _Inner<T>,
        accept_compression_encodings: EnabledCompressionEncodings,
        send_compression_encodings: EnabledCompressionEncodings,
    }
    struct _Inner<T>(Arc<T>);
    impl<T: UuidGenerator> UuidGeneratorServer<T> {
        pub fn new(inner: T) -> Self {
            Self::from_arc(Arc::new(inner))
        }
        pub fn from_arc(inner: Arc<T>) -> Self {
            let inner = _Inner(inner);
            Self {
                inner,
                accept_compression_encodings: Default::default(),
                send_compression_encodings: Default::default(),
            }
        }
        pub fn with_interceptor<F>(
            inner: T,
            interceptor: F,
        ) -> InterceptedService<Self, F>
        where
            F: tonic::service::Interceptor,
        {
            InterceptedService::new(Self::new(inner), interceptor)
        }
        /// Enable decompressing requests with the given encoding.
        #[must_use]
        pub fn accept_compressed(mut self, encoding: CompressionEncoding) -> Self {
            self.accept_compression_encodings.enable(encoding);
            self
        }
        /// Compress responses with the given encoding, if the client supports it.
        #[must_use]
        pub fn send_compressed(mut self, encoding: CompressionEncoding) -> Self {
            self.send_compression_encodings.enable(encoding);
            self
        }
    }
    impl<T, B> tonic::codegen::Service<http::Request<B>> for UuidGeneratorServer<T>
    where
        T: UuidGenerator,
        B: Body + Send + 'static,
        B::Error: Into<StdError> + Send + 'static,
    {
        type Response = http::Response<tonic::body::BoxBody>;
        type Error = std::convert::Infallible;
        type Future = BoxFuture<Self::Response, Self::Error>;
        fn poll_ready(
            &mut self,
            _cx: &mut Context<'_>,
        ) -> Poll<Result<(), Self::Error>> {
            Poll::Ready(Ok(()))
        }
        fn call(&mut self, req: http::Request<B>) -> Self::Future {
            let inner = self.inner.clone();
            match req.uri().path() {
                "/message.UUIDGenerator/GenerateUUID" => {
                    #[allow(non_camel_case_types)]
                    struct GenerateUUIDSvc<T: UuidGenerator>(pub Arc<T>);
                    impl<
                        T: UuidGenerator,
                    > tonic::server::UnaryService<super::GenerateUuidRequest>
                    for GenerateUUIDSvc<T> {
                        type Response = super::UuidEntity;
                        type Future = BoxFuture<
                            tonic::Response<Self::Response>,
                            tonic::Status,
                        >;
                        fn call(
                            &mut self,
                            request: tonic::Request<super::GenerateUuidRequest>,
                        ) -> Self::Future {
                            let inner = self.0.clone();
                            let fut = async move {
                                (*inner).generate_uuid(request).await
                            };
                            Box::pin(fut)
                        }
                    }
                    let accept_compression_encodings = self.accept_compression_encodings;
                    let send_compression_encodings = self.send_compression_encodings;
                    let inner = self.inner.clone();
                    let fut = async move {
                        let inner = inner.0;
                        let method = GenerateUUIDSvc(inner);
                        let codec = tonic::codec::ProstCodec::default();
                        let mut grpc = tonic::server::Grpc::new(codec)
                            .apply_compression_config(
                                accept_compression_encodings,
                                send_compression_encodings,
                            );
                        let res = grpc.unary(method, req).await;
                        Ok(res)
                    };
                    Box::pin(fut)
                }
                _ => {
                    Box::pin(async move {
                        Ok(
                            http::Response::builder()
                                .status(200)
                                .header("grpc-status", "12")
                                .header("content-type", "application/grpc")
                                .body(empty_body())
                                .unwrap(),
                        )
                    })
                }
            }
        }
    }
    impl<T: UuidGenerator> Clone for UuidGeneratorServer<T> {
        fn clone(&self) -> Self {
            let inner = self.inner.clone();
            Self {
                inner,
                accept_compression_encodings: self.accept_compression_encodings,
                send_compression_encodings: self.send_compression_encodings,
            }
        }
    }
    impl<T: UuidGenerator> Clone for _Inner<T> {
        fn clone(&self) -> Self {
            Self(self.0.clone())
        }
    }
    impl<T: std::fmt::Debug> std::fmt::Debug for _Inner<T> {
        fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
            write!(f, "{:?}", self.0)
        }
    }
    impl<T: UuidGenerator> tonic::server::NamedService for UuidGeneratorServer<T> {
        const NAME: &'static str = "message.UUIDGenerator";
    }
}
/// Generated server implementations.
pub mod messenger_server {
    #![allow(unused_variables, dead_code, missing_docs, clippy::let_unit_value)]
    use tonic::codegen::*;
    ///Generated trait containing gRPC methods that should be implemented for use with MessengerServer.
    #[async_trait]
    pub trait Messenger: Send + Sync + 'static {
        async fn get_message(
            &self,
            request: tonic::Request<super::GetMessageRequest>,
        ) -> Result<tonic::Response<super::MessageEntity>, tonic::Status>;
        async fn list_messages(
            &self,
            request: tonic::Request<super::GetMessagesRequest>,
        ) -> Result<tonic::Response<super::MessagesResponse>, tonic::Status>;
        async fn put_message(
            &self,
            request: tonic::Request<super::MessageEntity>,
        ) -> Result<tonic::Response<super::MessageEntity>, tonic::Status>;
        async fn delete_message(
            &self,
            request: tonic::Request<super::DeleteMessageRequest>,
        ) -> Result<tonic::Response<super::MessageEntity>, tonic::Status>;
        async fn delete_messages(
            &self,
            request: tonic::Request<super::DeleteMessagesRequest>,
        ) -> Result<tonic::Response<super::DeleteMessagesResponse>, tonic::Status>;
        async fn count_messages(
            &self,
            request: tonic::Request<super::CountMessagesRequest>,
        ) -> Result<tonic::Response<super::MessageCount>, tonic::Status>;
    }
    #[derive(Debug)]
    pub struct MessengerServer<T: Messenger> {
        inner: _Inner<T>,
        accept_compression_encodings: EnabledCompressionEncodings,
        send_compression_encodings: EnabledCompressionEncodings,
    }
    struct _Inner<T>(Arc<T>);
    impl<T: Messenger> MessengerServer<T> {
        pub fn new(inner: T) -> Self {
            Self::from_arc(Arc::new(inner))
        }
        pub fn from_arc(inner: Arc<T>) -> Self {
            let inner = _Inner(inner);
            Self {
                inner,
                accept_compression_encodings: Default::default(),
                send_compression_encodings: Default::default(),
            }
        }
        pub fn with_interceptor<F>(
            inner: T,
            interceptor: F,
        ) -> InterceptedService<Self, F>
        where
            F: tonic::service::Interceptor,
        {
            InterceptedService::new(Self::new(inner), interceptor)
        }
        /// Enable decompressing requests with the given encoding.
        #[must_use]
        pub fn accept_compressed(mut self, encoding: CompressionEncoding) -> Self {
            self.accept_compression_encodings.enable(encoding);
            self
        }
        /// Compress responses with the given encoding, if the client supports it.
        #[must_use]
        pub fn send_compressed(mut self, encoding: CompressionEncoding) -> Self {
            self.send_compression_encodings.enable(encoding);
            self
        }
    }
    impl<T, B> tonic::codegen::Service<http::Request<B>> for MessengerServer<T>
    where
        T: Messenger,
        B: Body + Send + 'static,
        B::Error: Into<StdError> + Send + 'static,
    {
        type Response = http::Response<tonic::body::BoxBody>;
        type Error = std::convert::Infallible;
        type Future = BoxFuture<Self::Response, Self::Error>;
        fn poll_ready(
            &mut self,
            _cx: &mut Context<'_>,
        ) -> Poll<Result<(), Self::Error>> {
            Poll::Ready(Ok(()))
        }
        fn call(&mut self, req: http::Request<B>) -> Self::Future {
            let inner = self.inner.clone();
            match req.uri().path() {
                "/message.Messenger/GetMessage" => {
                    #[allow(non_camel_case_types)]
                    struct GetMessageSvc<T: Messenger>(pub Arc<T>);
                    impl<
                        T: Messenger,
                    > tonic::server::UnaryService<super::GetMessageRequest>
                    for GetMessageSvc<T> {
                        type Response = super::MessageEntity;
                        type Future = BoxFuture<
                            tonic::Response<Self::Response>,
                            tonic::Status,
                        >;
                        fn call(
                            &mut self,
                            request: tonic::Request<super::GetMessageRequest>,
                        ) -> Self::Future {
                            let inner = self.0.clone();
                            let fut = async move { (*inner).get_message(request).await };
                            Box::pin(fut)
                        }
                    }
                    let accept_compression_encodings = self.accept_compression_encodings;
                    let send_compression_encodings = self.send_compression_encodings;
                    let inner = self.inner.clone();
                    let fut = async move {
                        let inner = inner.0;
                        let method = GetMessageSvc(inner);
                        let codec = tonic::codec::ProstCodec::default();
                        let mut grpc = tonic::server::Grpc::new(codec)
                            .apply_compression_config(
                                accept_compression_encodings,
                                send_compression_encodings,
                            );
                        let res = grpc.unary(method, req).await;
                        Ok(res)
                    };
                    Box::pin(fut)
                }
                "/message.Messenger/ListMessages" => {
                    #[allow(non_camel_case_types)]
                    struct ListMessagesSvc<T: Messenger>(pub Arc<T>);
                    impl<
                        T: Messenger,
                    > tonic::server::UnaryService<super::GetMessagesRequest>
                    for ListMessagesSvc<T> {
                        type Response = super::MessagesResponse;
                        type Future = BoxFuture<
                            tonic::Response<Self::Response>,
                            tonic::Status,
                        >;
                        fn call(
                            &mut self,
                            request: tonic::Request<super::GetMessagesRequest>,
                        ) -> Self::Future {
                            let inner = self.0.clone();
                            let fut = async move {
                                (*inner).list_messages(request).await
                            };
                            Box::pin(fut)
                        }
                    }
                    let accept_compression_encodings = self.accept_compression_encodings;
                    let send_compression_encodings = self.send_compression_encodings;
                    let inner = self.inner.clone();
                    let fut = async move {
                        let inner = inner.0;
                        let method = ListMessagesSvc(inner);
                        let codec = tonic::codec::ProstCodec::default();
                        let mut grpc = tonic::server::Grpc::new(codec)
                            .apply_compression_config(
                                accept_compression_encodings,
                                send_compression_encodings,
                            );
                        let res = grpc.unary(method, req).await;
                        Ok(res)
                    };
                    Box::pin(fut)
                }
                "/message.Messenger/PutMessage" => {
                    #[allow(non_camel_case_types)]
                    struct PutMessageSvc<T: Messenger>(pub Arc<T>);
                    impl<T: Messenger> tonic::server::UnaryService<super::MessageEntity>
                    for PutMessageSvc<T> {
                        type Response = super::MessageEntity;
                        type Future = BoxFuture<
                            tonic::Response<Self::Response>,
                            tonic::Status,
                        >;
                        fn call(
                            &mut self,
                            request: tonic::Request<super::MessageEntity>,
                        ) -> Self::Future {
                            let inner = self.0.clone();
                            let fut = async move { (*inner).put_message(request).await };
                            Box::pin(fut)
                        }
                    }
                    let accept_compression_encodings = self.accept_compression_encodings;
                    let send_compression_encodings = self.send_compression_encodings;
                    let inner = self.inner.clone();
                    let fut = async move {
                        let inner = inner.0;
                        let method = PutMessageSvc(inner);
                        let codec = tonic::codec::ProstCodec::default();
                        let mut grpc = tonic::server::Grpc::new(codec)
                            .apply_compression_config(
                                accept_compression_encodings,
                                send_compression_encodings,
                            );
                        let res = grpc.unary(method, req).await;
                        Ok(res)
                    };
                    Box::pin(fut)
                }
                "/message.Messenger/DeleteMessage" => {
                    #[allow(non_camel_case_types)]
                    struct DeleteMessageSvc<T: Messenger>(pub Arc<T>);
                    impl<
                        T: Messenger,
                    > tonic::server::UnaryService<super::DeleteMessageRequest>
                    for DeleteMessageSvc<T> {
                        type Response = super::MessageEntity;
                        type Future = BoxFuture<
                            tonic::Response<Self::Response>,
                            tonic::Status,
                        >;
                        fn call(
                            &mut self,
                            request: tonic::Request<super::DeleteMessageRequest>,
                        ) -> Self::Future {
                            let inner = self.0.clone();
                            let fut = async move {
                                (*inner).delete_message(request).await
                            };
                            Box::pin(fut)
                        }
                    }
                    let accept_compression_encodings = self.accept_compression_encodings;
                    let send_compression_encodings = self.send_compression_encodings;
                    let inner = self.inner.clone();
                    let fut = async move {
                        let inner = inner.0;
                        let method = DeleteMessageSvc(inner);
                        let codec = tonic::codec::ProstCodec::default();
                        let mut grpc = tonic::server::Grpc::new(codec)
                            .apply_compression_config(
                                accept_compression_encodings,
                                send_compression_encodings,
                            );
                        let res = grpc.unary(method, req).await;
                        Ok(res)
                    };
                    Box::pin(fut)
                }
                "/message.Messenger/DeleteMessages" => {
                    #[allow(non_camel_case_types)]
                    struct DeleteMessagesSvc<T: Messenger>(pub Arc<T>);
                    impl<
                        T: Messenger,
                    > tonic::server::UnaryService<super::DeleteMessagesRequest>
                    for DeleteMessagesSvc<T> {
                        type Response = super::DeleteMessagesResponse;
                        type Future = BoxFuture<
                            tonic::Response<Self::Response>,
                            tonic::Status,
                        >;
                        fn call(
                            &mut self,
                            request: tonic::Request<super::DeleteMessagesRequest>,
                        ) -> Self::Future {
                            let inner = self.0.clone();
                            let fut = async move {
                                (*inner).delete_messages(request).await
                            };
                            Box::pin(fut)
                        }
                    }
                    let accept_compression_encodings = self.accept_compression_encodings;
                    let send_compression_encodings = self.send_compression_encodings;
                    let inner = self.inner.clone();
                    let fut = async move {
                        let inner = inner.0;
                        let method = DeleteMessagesSvc(inner);
                        let codec = tonic::codec::ProstCodec::default();
                        let mut grpc = tonic::server::Grpc::new(codec)
                            .apply_compression_config(
                                accept_compression_encodings,
                                send_compression_encodings,
                            );
                        let res = grpc.unary(method, req).await;
                        Ok(res)
                    };
                    Box::pin(fut)
                }
                "/message.Messenger/CountMessages" => {
                    #[allow(non_camel_case_types)]
                    struct CountMessagesSvc<T: Messenger>(pub Arc<T>);
                    impl<
                        T: Messenger,
                    > tonic::server::UnaryService<super::CountMessagesRequest>
                    for CountMessagesSvc<T> {
                        type Response = super::MessageCount;
                        type Future = BoxFuture<
                            tonic::Response<Self::Response>,
                            tonic::Status,
                        >;
                        fn call(
                            &mut self,
                            request: tonic::Request<super::CountMessagesRequest>,
                        ) -> Self::Future {
                            let inner = self.0.clone();
                            let fut = async move {
                                (*inner).count_messages(request).await
                            };
                            Box::pin(fut)
                        }
                    }
                    let accept_compression_encodings = self.accept_compression_encodings;
                    let send_compression_encodings = self.send_compression_encodings;
                    let inner = self.inner.clone();
                    let fut = async move {
                        let inner = inner.0;
                        let method = CountMessagesSvc(inner);
                        let codec = tonic::codec::ProstCodec::default();
                        let mut grpc = tonic::server::Grpc::new(codec)
                            .apply_compression_config(
                                accept_compression_encodings,
                                send_compression_encodings,
                            );
                        let res = grpc.unary(method, req).await;
                        Ok(res)
                    };
                    Box::pin(fut)
                }
                _ => {
                    Box::pin(async move {
                        Ok(
                            http::Response::builder()
                                .status(200)
                                .header("grpc-status", "12")
                                .header("content-type", "application/grpc")
                                .body(empty_body())
                                .unwrap(),
                        )
                    })
                }
            }
        }
    }
    impl<T: Messenger> Clone for MessengerServer<T> {
        fn clone(&self) -> Self {
            let inner = self.inner.clone();
            Self {
                inner,
                accept_compression_encodings: self.accept_compression_encodings,
                send_compression_encodings: self.send_compression_encodings,
            }
        }
    }
    impl<T: Messenger> Clone for _Inner<T> {
        fn clone(&self) -> Self {
            Self(self.0.clone())
        }
    }
    impl<T: std::fmt::Debug> std::fmt::Debug for _Inner<T> {
        fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
            write!(f, "{:?}", self.0)
        }
    }
    impl<T: Messenger> tonic::server::NamedService for MessengerServer<T> {
        const NAME: &'static str = "message.Messenger";
    }
}
