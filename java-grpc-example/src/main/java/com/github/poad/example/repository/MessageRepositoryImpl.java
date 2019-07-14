package com.github.poad.example.repository;

import com.github.poad.example.grpc.client.MessageClient;
import com.github.poad.example.grpc.MessageEntity;
import com.github.poad.example.grpc.UUIDEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final MessageClient client;
    MessageRepositoryImpl(@Autowired MessageClient client) {
        this.client = client;
    }

    @Override
    public <S extends MessageEntity> S save(S s) {
        return (S) client.putMessage(s);
    }

    @Override
    public Optional<MessageEntity> findById(String id) {
        return client.getMessage(id);
    }

    @Override
    public boolean existsById(String id) {
        return client.getMessage(id).isPresent();
    }

    @Override
    public List<MessageEntity> findAll() {
        return client.getMessages();
    }

    @Override
    public long count() {
        return client.countMessages().getCount();
    }

    @Override
    public void deleteById(String id) {
        client.deleteById(id);
    }

    @Override
    public void delete(MessageEntity entity) {
        client.deleteMessage(entity);
    }

    @Override
    public <S extends MessageEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<MessageEntity> findAllById(Iterable<String> id) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void deleteAll(Iterable<? extends MessageEntity> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        client.deleteMessages();
    }

    @Override
    public UUIDEntity generateUUID() {
        return client.generateUUID();
    }
}
