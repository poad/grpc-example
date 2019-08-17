package com.github.poad.example.service;

import com.github.poad.example.grpc.HelloReply;
import com.github.poad.example.grpc.HelloRequest;
import com.github.poad.example.grpc.client.HelloClient;
import com.github.poad.example.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloServiceImpl implements HelloService {

    private final HelloClient client;

    HelloServiceImpl(@Autowired HelloClient client) {
        this.client = client;
    }

    @Override
    public Optional<Hello> sayHello(String name) {
        return client.sayHello(HelloRequest.newBuilder().setName(name).build())
                .map(entity -> new Hello(entity.getMessage()));
    }
}
