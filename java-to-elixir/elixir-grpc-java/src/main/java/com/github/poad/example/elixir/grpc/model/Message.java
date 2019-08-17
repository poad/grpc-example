package com.github.poad.example.elixir.grpc.model;

public class Message {
    private final String id;
    private final String message;

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
