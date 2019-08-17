package com.github.poad.example.service;

import com.github.poad.example.grpc.MessageEntity;
import com.github.poad.example.grpc.UUIDEntity;
import com.github.poad.example.model.Message;
import com.github.poad.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repository;

    MessageServiceImpl(@Autowired MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Message> all() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entity -> new Message(entity.getId().getValue(), entity.getMessage()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Message> get(String id) {
        return repository.findById(id).map(entity -> new Message(entity.getId().getValue(), entity.getMessage()));
    }

    @Override
    public Message create(Message message) {
        MessageEntity entity = repository.save(MessageEntity.newBuilder()
                .setId(repository.generateUUID())
                .setMessage(message.getMessage())
                .build());
        return new Message(entity.getId().getValue(), entity.getMessage());
    }

    @Override
    public Optional<Message> update(String id, Message message) {
        Optional<MessageEntity> current = repository.findById(id);
        if (current.isEmpty()) {
            return Optional.empty();
        }
        UUIDEntity uuid = UUIDEntity.newBuilder().setValue(id).build();
        MessageEntity entity = MessageEntity.newBuilder()
                .setId(uuid)
                .setMessage(message.getMessage())
                .build();
        repository.save(entity);
        return Optional.of(new Message(id, message.getMessage()));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
