package com.github.poad.example.service;

import com.github.poad.example.model.Message;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Valid
@Service
public interface MessageService {
    List<Message> all();

    Optional<Message> get(String id);

    Message create(Message message);

    Optional<Message> update(String id, Message message);

    void delete(String id);

    void deleteAll();
}
