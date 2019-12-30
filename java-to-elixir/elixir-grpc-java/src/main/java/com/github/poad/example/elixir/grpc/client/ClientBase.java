package com.github.poad.example.elixir.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public abstract class ClientBase {
    private static final Logger logger = LoggerFactory.getLogger(ClientBase.class.getPackageName());

    protected final ManagedChannel channel;

    protected ClientBase(String host, int port) {
        logger.info(String.format("target %s:%d by %s", host, port, this.getClass().getName()));
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext().build();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
