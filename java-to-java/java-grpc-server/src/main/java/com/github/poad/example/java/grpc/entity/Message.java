package com.github.poad.example.java.grpc.entity;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "message")
public class Message {
    @Id
    private final String id;

    @Column(nullable = false)
    private final String message;

    // for JPA
    public Message() {
        this(null, null);
    }

    public Message(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
