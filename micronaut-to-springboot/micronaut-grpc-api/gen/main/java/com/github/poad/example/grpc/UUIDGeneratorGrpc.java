package com.github.poad.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: message.proto")
public final class UUIDGeneratorGrpc {

  private UUIDGeneratorGrpc() {}

  public static final String SERVICE_NAME = "message.UUIDGenerator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.poad.example.grpc.GenerateUUIDRequest,
      com.github.poad.example.grpc.UUIDEntity> getGenerateUUIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateUUID",
      requestType = com.github.poad.example.grpc.GenerateUUIDRequest.class,
      responseType = com.github.poad.example.grpc.UUIDEntity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.poad.example.grpc.GenerateUUIDRequest,
      com.github.poad.example.grpc.UUIDEntity> getGenerateUUIDMethod() {
    io.grpc.MethodDescriptor<com.github.poad.example.grpc.GenerateUUIDRequest, com.github.poad.example.grpc.UUIDEntity> getGenerateUUIDMethod;
    if ((getGenerateUUIDMethod = UUIDGeneratorGrpc.getGenerateUUIDMethod) == null) {
      synchronized (UUIDGeneratorGrpc.class) {
        if ((getGenerateUUIDMethod = UUIDGeneratorGrpc.getGenerateUUIDMethod) == null) {
          UUIDGeneratorGrpc.getGenerateUUIDMethod = getGenerateUUIDMethod =
              io.grpc.MethodDescriptor.<com.github.poad.example.grpc.GenerateUUIDRequest, com.github.poad.example.grpc.UUIDEntity>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateUUID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.GenerateUUIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.poad.example.grpc.UUIDEntity.getDefaultInstance()))
              .setSchemaDescriptor(new UUIDGeneratorMethodDescriptorSupplier("GenerateUUID"))
              .build();
        }
      }
    }
    return getGenerateUUIDMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UUIDGeneratorStub newStub(io.grpc.Channel channel) {
    return new UUIDGeneratorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UUIDGeneratorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UUIDGeneratorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UUIDGeneratorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UUIDGeneratorFutureStub(channel);
  }

  /**
   */
  public static abstract class UUIDGeneratorImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateUUID(com.github.poad.example.grpc.GenerateUUIDRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.UUIDEntity> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateUUIDMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateUUIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.github.poad.example.grpc.GenerateUUIDRequest,
                com.github.poad.example.grpc.UUIDEntity>(
                  this, METHODID_GENERATE_UUID)))
          .build();
    }
  }

  /**
   */
  public static final class UUIDGeneratorStub extends io.grpc.stub.AbstractStub<UUIDGeneratorStub> {
    private UUIDGeneratorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UUIDGeneratorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UUIDGeneratorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UUIDGeneratorStub(channel, callOptions);
    }

    /**
     */
    public void generateUUID(com.github.poad.example.grpc.GenerateUUIDRequest request,
        io.grpc.stub.StreamObserver<com.github.poad.example.grpc.UUIDEntity> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateUUIDMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UUIDGeneratorBlockingStub extends io.grpc.stub.AbstractStub<UUIDGeneratorBlockingStub> {
    private UUIDGeneratorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UUIDGeneratorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UUIDGeneratorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UUIDGeneratorBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.github.poad.example.grpc.UUIDEntity generateUUID(com.github.poad.example.grpc.GenerateUUIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateUUIDMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UUIDGeneratorFutureStub extends io.grpc.stub.AbstractStub<UUIDGeneratorFutureStub> {
    private UUIDGeneratorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UUIDGeneratorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UUIDGeneratorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UUIDGeneratorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.poad.example.grpc.UUIDEntity> generateUUID(
        com.github.poad.example.grpc.GenerateUUIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateUUIDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_UUID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UUIDGeneratorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UUIDGeneratorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_UUID:
          serviceImpl.generateUUID((com.github.poad.example.grpc.GenerateUUIDRequest) request,
              (io.grpc.stub.StreamObserver<com.github.poad.example.grpc.UUIDEntity>) responseObserver);
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

  private static abstract class UUIDGeneratorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UUIDGeneratorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.poad.example.grpc.MessageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UUIDGenerator");
    }
  }

  private static final class UUIDGeneratorFileDescriptorSupplier
      extends UUIDGeneratorBaseDescriptorSupplier {
    UUIDGeneratorFileDescriptorSupplier() {}
  }

  private static final class UUIDGeneratorMethodDescriptorSupplier
      extends UUIDGeneratorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UUIDGeneratorMethodDescriptorSupplier(String methodName) {
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
      synchronized (UUIDGeneratorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UUIDGeneratorFileDescriptorSupplier())
              .addMethod(getGenerateUUIDMethod())
              .build();
        }
      }
    }
    return result;
  }
}
