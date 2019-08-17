package com.github.poad.example.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class ClientBase {
    protected final ManagedChannel channel;

    public ClientBase(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext().build();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

}
