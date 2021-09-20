package com.github.poad.example.micronaut.grpc.service;

import com.github.poad.example.grpc.*;
import com.github.poad.example.micronaut.grpc.entity.Message;
import com.github.poad.example.micronaut.grpc.exception.NotFoundException;
import com.github.poad.example.micronaut.grpc.repository.MessageRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;

@GrpcService
public class MessageService extends MessengerGrpc.MessengerImplBase {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
    private final MessageRepository repository;

    public MessageService(@Autowired MessageRepository repository) {
        this.repository = repository;
    }

    public void getMessage(GetMessageRequest request, StreamObserver<MessageEntity> responseObserver) {
        Optional<Message> e = repository.findById(request.getId().getValue());
                e.ifPresent(entity -> {
                    UUIDEntity id = UUIDEntity.newBuilder().setValue(entity.getId()).build();
                    MessageEntity reply = MessageEntity.newBuilder().setId(id).setMessage(entity.getMessage()).build();
                    responseObserver.onNext(reply);
                });
                if (!e.isPresent()) {
                    responseObserver.onError(new NotFoundException());
                }
        responseObserver.onCompleted();
    }

    public void listMessages(GetMessagesRequest request, StreamObserver<MessagesResponse> responseObserver) {
        MessagesResponse reply = MessagesResponse.newBuilder().addAllMessages(
                repository.findAll().stream().map(entity -> {
                    UUIDEntity id = UUIDEntity.newBuilder().setValue(entity.getId()).build();
                    return MessageEntity.newBuilder().setId(id).setMessage(entity.getMessage()).build();
                }).collect(Collectors.toList())).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    public void putMessage(MessageEntity request, StreamObserver<MessageEntity> responseObserver) {
        Message entity = repository.findById(request.getId().getValue())
                .map(current -> new Message(current.getId(), request.getMessage()))
                .orElse(new Message(request.getId().getValue(), request.getMessage()));
        Message result = repository.saveAndFlush(entity);
        UUIDEntity id = UUIDEntity.newBuilder().setValue(entity.getId()).build();
        MessageEntity reply = MessageEntity.newBuilder().setId(id).setMessage(entity.getMessage()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    public void deleteMessage(DeleteMessageRequest request, StreamObserver<MessageEntity> responseObserver) {
        Optional<Message> e = repository.findById(request.getId().getValue());
                e.ifPresent(entity -> {
                    UUIDEntity id = UUIDEntity.newBuilder().setValue(entity.getId()).build();
                    MessageEntity reply = MessageEntity.newBuilder().setId(id).setMessage(entity.getMessage()).build();
                    repository.deleteById(id.getValue());
                    responseObserver.onNext(reply);
                });
        if (!e.isPresent()) {
            responseObserver.onError(new NotFoundException());
        }
        responseObserver.onCompleted();
    }

    public void deleteMessages(DeleteMessagesRequest request, StreamObserver<DeleteMessagesResponse> responseObserver) {
        repository.deleteAll();
        responseObserver.onNext(DeleteMessagesResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    public void countMessages(CountMessagesRequest request, StreamObserver<MessageCount> responseObserver) {
        long count = repository.count();
        responseObserver.onNext(MessageCount.newBuilder().setCount(count).build());
        responseObserver.onCompleted();
    }
}
