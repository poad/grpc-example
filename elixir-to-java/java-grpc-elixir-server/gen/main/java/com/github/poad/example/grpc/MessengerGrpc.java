package com.github.poad.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: message.proto")
public final class MessengerGrpc {

  private MessengerGrpc() {}

  public static final String SERVICE_NAME = "message.Messenger";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.poad.example.grpc.GetMessageRequest,
      com.github.poad.example.grpc.MessageEntity> getGetMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMessage",
      requestType = com.github.poad.example.grpc.GetMessageRequest.class,
      responseType = com.github.poad.example.grpc.MessageEntity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.poad.example.grpc.GetMessageRequest,
      com.github.poad.example.grpc.MessageEntity> getGetMessageMethod() {
    io.grpc.MethodDescriptor<com.github.poad.example.grpc.GetMessageRequest, com.github.poad.example.grpc.MessageEntity> getGetMessageMethod;
    if ((getGetMessageMethod = MessengerGrpc.getGetMessageMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getGetMessageMethod = MessengerGrpc.getGetMessageMethod) == null) {
          MessengerGrpc.getGetMessageMethod = getGetMessageMethod =
              io.grpc.MethodDescriptor.<com.github.poad.example.grpc.GetMessageRequest, com.github.poad.example.grpc.MessageEntity>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.GetMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.MessageEntity.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("GetMessage"))
              .build();
        }
      }
    }
    return getGetMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.poad.example.grpc.GetMessagesRequest,
      com.github.poad.example.grpc.MessagesResponse> getListMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMessages",
      requestType = com.github.poad.example.grpc.GetMessagesRequest.class,
      responseType = com.github.poad.example.grpc.MessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.poad.example.grpc.GetMessagesRequest,
      com.github.poad.example.grpc.MessagesResponse> getListMessagesMethod() {
    io.grpc.MethodDescriptor<com.github.poad.example.grpc.GetMessagesRequest, com.github.poad.example.grpc.MessagesResponse> getListMessagesMethod;
    if ((getListMessagesMethod = MessengerGrpc.getListMessagesMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getListMessagesMethod = MessengerGrpc.getListMessagesMethod) == null) {
          MessengerGrpc.getListMessagesMethod = getListMessagesMethod =
              io.grpc.MethodDescriptor.<com.github.poad.example.grpc.GetMessagesRequest, com.github.poad.example.grpc.MessagesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.GetMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.MessagesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("ListMessages"))
              .build();
        }
      }
    }
    return getListMessagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.poad.example.grpc.MessageEntity,
      com.github.poad.example.grpc.MessageEntity> getPutMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PutMessage",
      requestType = com.github.poad.example.grpc.MessageEntity.class,
      responseType = com.github.poad.example.grpc.MessageEntity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.poad.example.grpc.MessageEntity,
      com.github.poad.example.grpc.MessageEntity> getPutMessageMethod() {
    io.grpc.MethodDescriptor<com.github.poad.example.grpc.MessageEntity, com.github.poad.example.grpc.MessageEntity> getPutMessageMethod;
    if ((getPutMessageMethod = MessengerGrpc.getPutMessageMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getPutMessageMethod = MessengerGrpc.getPutMessageMethod) == null) {
          MessengerGrpc.getPutMessageMethod = getPutMessageMethod =
              io.grpc.MethodDescriptor.<com.github.poad.example.grpc.MessageEntity, com.github.poad.example.grpc.MessageEntity>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PutMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.MessageEntity.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.MessageEntity.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("PutMessage"))
              .build();
        }
      }
    }
    return getPutMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.poad.example.grpc.DeleteMessageRequest,
      com.github.poad.example.grpc.MessageEntity> getDeleteMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMessage",
      requestType = com.github.poad.example.grpc.DeleteMessageRequest.class,
      responseType = com.github.poad.example.grpc.MessageEntity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.poad.example.grpc.DeleteMessageRequest,
      com.github.poad.example.grpc.MessageEntity> getDeleteMessageMethod() {
    io.grpc.MethodDescriptor<com.github.poad.example.grpc.DeleteMessageRequest, com.github.poad.example.grpc.MessageEntity> getDeleteMessageMethod;
    if ((getDeleteMessageMethod = MessengerGrpc.getDeleteMessageMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getDeleteMessageMethod = MessengerGrpc.getDeleteMessageMethod) == null) {
          MessengerGrpc.getDeleteMessageMethod = getDeleteMessageMethod =
              io.grpc.MethodDescriptor.<com.github.poad.example.grpc.DeleteMessageRequest, com.github.poad.example.grpc.MessageEntity>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.DeleteMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.MessageEntity.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("DeleteMessage"))
              .build();
        }
      }
    }
    return getDeleteMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.poad.example.grpc.DeleteMessagesRequest,
      com.github.poad.example.grpc.DeleteMessagesResponse> getDeleteMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMessages",
      requestType = com.github.poad.example.grpc.DeleteMessagesRequest.class,
      responseType = com.github.poad.example.grpc.DeleteMessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.poad.example.grpc.DeleteMessagesRequest,
      com.github.poad.example.grpc.DeleteMessagesResponse> getDeleteMessagesMethod() {
    io.grpc.MethodDescriptor<com.github.poad.example.grpc.DeleteMessagesRequest, com.github.poad.example.grpc.DeleteMessagesResponse> getDeleteMessagesMethod;
    if ((getDeleteMessagesMethod = MessengerGrpc.getDeleteMessagesMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getDeleteMessagesMethod = MessengerGrpc.getDeleteMessagesMethod) == null) {
          MessengerGrpc.getDeleteMessagesMethod = getDeleteMessagesMethod =
              io.grpc.MethodDescriptor.<com.github.poad.example.grpc.DeleteMessagesRequest, com.github.poad.example.grpc.DeleteMessagesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.DeleteMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.DeleteMessagesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("DeleteMessages"))
              .build();
        }
      }
    }
    return getDeleteMessagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.poad.example.grpc.CountMessagesRequest,
      com.github.poad.example.grpc.MessageCount> getCountMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CountMessages",
      requestType = com.github.poad.example.grpc.CountMessagesRequest.class,
      responseType = com.github.poad.example.grpc.MessageCount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.poad.example.grpc.CountMessagesRequest,
      com.github.poad.example.grpc.MessageCount> getCountMessagesMethod() {
    io.grpc.MethodDescriptor<com.github.poad.example.grpc.CountMessagesRequest, com.github.poad.example.grpc.MessageCount> getCountMessagesMethod;
    if ((getCountMessagesMethod = MessengerGrpc.getCountMessagesMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getCountMessagesMethod = MessengerGrpc.getCountMessagesMethod) == null) {
          MessengerGrpc.getCountMessagesMethod = getCountMessagesMethod =
              io.grpc.MethodDescriptor.<com.github.poad.example.grpc.CountMessagesRequest, com.github.poad.example.grpc.MessageCount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CountMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.CountMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.MessageCount.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("CountMessages"))
              .build();
        }
      }
    }
    return getCountMessagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessengerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessengerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessengerStub>() {
        @java.lang.Override
        public MessengerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessengerStub(channel, callOptions);
        }
      };
    return MessengerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessengerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessengerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessengerBlockingStub>() {
        @java.lang.Override
        public MessengerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessengerBlockingStub(channel, callOptions);
        }
      };
    return MessengerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessengerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessengerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessengerFutureStub>() {
        @java.lang.Override
        public MessengerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessengerFutureStub(channel, callOptions);
        }
      };
    return MessengerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MessengerImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMessage(com.github.poad.example.grpc.GetMessageRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageEntity> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMessageMethod(), responseObserver);
    }

    /**
     */
    public void listMessages(com.github.poad.example.grpc.GetMessagesRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessagesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMessagesMethod(), responseObserver);
    }

    /**
     */
    public void putMessage(com.github.poad.example.grpc.MessageEntity request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageEntity> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutMessageMethod(), responseObserver);
    }

    /**
     */
    public void deleteMessage(com.github.poad.example.grpc.DeleteMessageRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageEntity> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMessageMethod(), responseObserver);
    }

    /**
     */
    public void deleteMessages(com.github.poad.example.grpc.DeleteMessagesRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.DeleteMessagesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMessagesMethod(), responseObserver);
    }

    /**
     */
    public void countMessages(com.github.poad.example.grpc.CountMessagesRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageCount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCountMessagesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.github.poad.example.grpc.GetMessageRequest,
                com.github.poad.example.grpc.MessageEntity>(
                  this, METHODID_GET_MESSAGE)))
          .addMethod(
            getListMessagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.github.poad.example.grpc.GetMessagesRequest,
                com.github.poad.example.grpc.MessagesResponse>(
                  this, METHODID_LIST_MESSAGES)))
          .addMethod(
            getPutMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.github.poad.example.grpc.MessageEntity,
                com.github.poad.example.grpc.MessageEntity>(
                  this, METHODID_PUT_MESSAGE)))
          .addMethod(
            getDeleteMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.github.poad.example.grpc.DeleteMessageRequest,
                com.github.poad.example.grpc.MessageEntity>(
                  this, METHODID_DELETE_MESSAGE)))
          .addMethod(
            getDeleteMessagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.github.poad.example.grpc.DeleteMessagesRequest,
                com.github.poad.example.grpc.DeleteMessagesResponse>(
                  this, METHODID_DELETE_MESSAGES)))
          .addMethod(
            getCountMessagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.github.poad.example.grpc.CountMessagesRequest,
                com.github.poad.example.grpc.MessageCount>(
                  this, METHODID_COUNT_MESSAGES)))
          .build();
    }
  }

  /**
   */
  public static final class MessengerStub extends io.grpc.stub.AbstractAsyncStub<MessengerStub> {
    private MessengerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessengerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessengerStub(channel, callOptions);
    }

    /**
     */
    public void getMessage(com.github.poad.example.grpc.GetMessageRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageEntity> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listMessages(com.github.poad.example.grpc.GetMessagesRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessagesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMessagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putMessage(com.github.poad.example.grpc.MessageEntity request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageEntity> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteMessage(com.github.poad.example.grpc.DeleteMessageRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageEntity> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteMessages(com.github.poad.example.grpc.DeleteMessagesRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.DeleteMessagesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMessagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void countMessages(com.github.poad.example.grpc.CountMessagesRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageCount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCountMessagesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessengerBlockingStub extends io.grpc.stub.AbstractBlockingStub<MessengerBlockingStub> {
    private MessengerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessengerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessengerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.github.poad.example.grpc.MessageEntity getMessage(com.github.poad.example.grpc.GetMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.github.poad.example.grpc.MessagesResponse listMessages(com.github.poad.example.grpc.GetMessagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMessagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.github.poad.example.grpc.MessageEntity putMessage(com.github.poad.example.grpc.MessageEntity request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.github.poad.example.grpc.MessageEntity deleteMessage(com.github.poad.example.grpc.DeleteMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.github.poad.example.grpc.DeleteMessagesResponse deleteMessages(com.github.poad.example.grpc.DeleteMessagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMessagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.github.poad.example.grpc.MessageCount countMessages(com.github.poad.example.grpc.CountMessagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCountMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessengerFutureStub extends io.grpc.stub.AbstractFutureStub<MessengerFutureStub> {
    private MessengerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessengerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessengerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.poad.example.grpc.MessageEntity> getMessage(
        com.github.poad.example.grpc.GetMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.poad.example.grpc.MessagesResponse> listMessages(
        com.github.poad.example.grpc.GetMessagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMessagesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.poad.example.grpc.MessageEntity> putMessage(
        com.github.poad.example.grpc.MessageEntity request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.poad.example.grpc.MessageEntity> deleteMessage(
        com.github.poad.example.grpc.DeleteMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.poad.example.grpc.DeleteMessagesResponse> deleteMessages(
        com.github.poad.example.grpc.DeleteMessagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMessagesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.poad.example.grpc.MessageCount> countMessages(
        com.github.poad.example.grpc.CountMessagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCountMessagesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MESSAGE = 0;
  private static final int METHODID_LIST_MESSAGES = 1;
  private static final int METHODID_PUT_MESSAGE = 2;
  private static final int METHODID_DELETE_MESSAGE = 3;
  private static final int METHODID_DELETE_MESSAGES = 4;
  private static final int METHODID_COUNT_MESSAGES = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessengerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessengerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage((com.github.poad.example.grpc.GetMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageEntity>) responseObserver);
          break;
        case METHODID_LIST_MESSAGES:
          serviceImpl.listMessages((com.github.poad.example.grpc.GetMessagesRequest) request,
              (io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessagesResponse>) responseObserver);
          break;
        case METHODID_PUT_MESSAGE:
          serviceImpl.putMessage((com.github.poad.example.grpc.MessageEntity) request,
              (io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageEntity>) responseObserver);
          break;
        case METHODID_DELETE_MESSAGE:
          serviceImpl.deleteMessage((com.github.poad.example.grpc.DeleteMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageEntity>) responseObserver);
          break;
        case METHODID_DELETE_MESSAGES:
          serviceImpl.deleteMessages((com.github.poad.example.grpc.DeleteMessagesRequest) request,
              (io.grpc.stub.StreamObserver<com.github.poad.example.grpc.DeleteMessagesResponse>) responseObserver);
          break;
        case METHODID_COUNT_MESSAGES:
          serviceImpl.countMessages((com.github.poad.example.grpc.CountMessagesRequest) request,
              (io.grpc.stub.StreamObserver<com.github.poad.example.grpc.MessageCount>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessengerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessengerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.poad.example.grpc.MessageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Messenger");
    }
  }

  private static final class MessengerFileDescriptorSupplier
      extends MessengerBaseDescriptorSupplier {
    MessengerFileDescriptorSupplier() {}
  }

  private static final class MessengerMethodDescriptorSupplier
      extends MessengerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessengerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessengerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessengerFileDescriptorSupplier())
              .addMethod(getGetMessageMethod())
              .addMethod(getListMessagesMethod())
              .addMethod(getPutMessageMethod())
              .addMethod(getDeleteMessageMethod())
              .addMethod(getDeleteMessagesMethod())
              .addMethod(getCountMessagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
