package com.github.poad.example.micronaut.grpc.service;

import com.github.poad.example.grpc.GenerateUUIDRequest;
import com.github.poad.example.grpc.UUIDEntity;
import com.github.poad.example.grpc.UUIDGeneratorGrpc;
import com.github.poad.example.micronaut.grpc.repository.MessageRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class UuidService extends UUIDGeneratorGrpc.UUIDGeneratorImplBase {
    private final MessageRepository repository;

    public UuidService(@Autowired MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void generateUUID(GenerateUUIDRequest request, StreamObserver<UUIDEntity> responseObserver) {
        String uuid = repository.uuid();
        UUIDEntity reply = UUIDEntity.newBuilder().setValue(uuid).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
