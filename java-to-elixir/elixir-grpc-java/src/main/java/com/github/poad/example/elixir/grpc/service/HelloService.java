package com.github.poad.example.elixir.grpc.service;

import com.github.poad.example.elixir.grpc.client.HelloClient;
import com.github.poad.example.elixir.grpc.model.Hello;
import com.github.poad.example.grpc.HelloRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
    private final HelloClient client;

    HelloService(@Autowired HelloClient client) {
        this.client = client;
    }

    public Optional<Hello> sayHello(String name) {
        try {
            return client.sayHello(HelloRequest.newBuilder().setName(name).build())
                    .map(entity -> new Hello(entity.getMessage()));
        } catch (RuntimeException e) {
            logger.warn("", e);
            throw e;
        }
    }
}
