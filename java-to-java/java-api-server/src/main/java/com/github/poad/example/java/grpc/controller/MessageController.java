package com.github.poad.example.java.grpc.controller;

import com.github.poad.example.java.grpc.exception.NotFoundException;
import com.github.poad.example.java.grpc.model.Message;
import com.github.poad.example.java.grpc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Validated
@RestController
@RequestMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {
    private final MessageService service;

    MessageController(@Autowired MessageService service) {
        this.service = service;
    }

    @GetMapping
    Collection<Message> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    Message byId(@NotBlank @PathVariable String id) {
        return service.get(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    Message create(@NotNull @RequestBody Message message) {
        return service.create(message);
    }

    @PutMapping(value = "/{id}")
    Message uodate(@NotBlank @PathVariable String id, @NotNull @RequestBody Message message) {
        return service.update(id, message).orElseThrow(NotFoundException::new);
    }

    @DeleteMapping("/{id}")
    void delete(@NotBlank @PathVariable String id) {
        service.delete(id);
    }

    @DeleteMapping("/")
    void deleteAll() {
        service.deleteAll();
    }
}
