package com.github.poad.example.elixir.grpc.client;

public class  EndpointConfig {
    private final String host;
    private final int port;

    public EndpointConfig(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
