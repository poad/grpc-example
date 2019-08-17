package com.github.poad.example.elixir.grpc.model;

public class Hello {
    private final String message;

    public Hello() {
        this(null);
    }

    public Hello(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
