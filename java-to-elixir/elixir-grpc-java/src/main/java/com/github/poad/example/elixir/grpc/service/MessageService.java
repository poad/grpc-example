package com.github.poad.example.elixir.grpc.service;

import com.github.poad.example.elixir.grpc.client.MessageClient;
import com.github.poad.example.elixir.grpc.client.UuidClient;
import com.github.poad.example.elixir.grpc.model.Message;
import com.github.poad.example.grpc.MessageEntity;
import com.github.poad.example.grpc.UUIDEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    private final MessageClient client;
    private final UuidClient uuidClient;

    public MessageService(@Autowired MessageClient client, @Autowired UuidClient uuidClient) {
        this.client = client;
        this.uuidClient = uuidClient;
    }

    public List<Message> all() {
        try {
            return client.getMessages().stream()
                    .map(entity -> new Message(entity.getId().getValue(), entity.getMessage()))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            logger.warn("", e);
            throw e;
        }
    }

    public Optional<Message> get(String id) {
        try {
            return client.getMessage(id).map(entity -> new Message(entity.getId().getValue(), entity.getMessage()));
        } catch (RuntimeException e) {
            logger.warn("", e);
            throw e;
        }
    }

    public Message create(Message message) {
        try {
            MessageEntity entity = client.putMessage(MessageEntity.newBuilder()
                    .setId(uuidClient.generateUUID())
                    .setMessage(message.getMessage())
                    .build());
            return new Message(entity.getId().getValue(), entity.getMessage());
        } catch (RuntimeException e) {
            logger.warn("", e);
            throw e;
        }
    }

    public Optional<Message> update(String id, Message message) {
        try {
            Optional<MessageEntity> current = client.getMessage(id);
            if (current.isEmpty()) {
                return Optional.empty();
        }
            UUIDEntity uuid = UUIDEntity.newBuilder().setValue(id).build();
            MessageEntity entity = MessageEntity.newBuilder()
                    .setId(uuid)
                    .setMessage(message.getMessage())
                    .build();
            client.putMessage(entity);
            return Optional.of(new Message(id, message.getMessage()));
        } catch (RuntimeException e) {
            logger.warn("", e);
            throw e;
        }
    }

    public void delete(String id) {
        try {
            client.deleteById(id);
        } catch (RuntimeException e) {
            logger.warn("", e);
            throw e;
        }
    }

    public void deleteAll() {
        try {
            client.deleteMessages();
        } catch (RuntimeException e) {
            logger.warn("", e);
            throw e;
        }
    }
}
