package com.github.poad.example.grpc.client;

import com.github.poad.example.grpc.GreeterGrpc;
import com.github.poad.example.grpc.HelloReply;
import com.github.poad.example.grpc.HelloRequest;
import com.github.poad.example.grpc.client.config.EndpointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class HelloClient extends ClientBase {
    private final GreeterGrpc.GreeterBlockingStub helloService;

    public HelloClient(@Autowired EndpointConfig config) {
        super(config.getHost(), config.getPort());

        helloService = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public Optional<HelloReply> sayHello(HelloRequest request) {
        return Optional.ofNullable(helloService.sayHello(request));
    }
}
