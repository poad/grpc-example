package com.github.poad.example.java.grpc.service;

import com.github.poad.example.grpc.GenerateUUIDRequest;
import com.github.poad.example.grpc.UUIDEntity;
import com.github.poad.example.grpc.UUIDGeneratorGrpc;
import com.github.poad.example.java.grpc.repository.MessageRepository;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class UuidService extends UUIDGeneratorGrpc.UUIDGeneratorImplBase {
    private final MessageRepository repository;

    public UuidService(@Autowired MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void generateUUID(GenerateUUIDRequest request, StreamObserver<UUIDEntity> responseObserver) {
        final var uuid = repository.uuid();
        var reply = UUIDEntity.newBuilder().setValue(uuid).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
