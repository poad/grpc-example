package com.github.poad.example;

import com.github.poad.example.grpc.client.config.EndpointConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringBootGRpcApp extends SpringBootServletInitializer {
    public static void main( String... args ) {
        new SpringBootGRpcApp()
                .configure(new SpringApplicationBuilder(SpringBootGRpcApp.class))
                .run(args);
    }

    @Bean
    public EndpointConfig gRpcEndpoint() {
        String endpoint = System.getProperty("GRPC_ENDPOINT", "127.0.0.1");
        int port = Optional.ofNullable(System.getenv("GRPC_ENDPOINT_PORT"))
                .map(Integer::valueOf).orElse(50051);
        return new EndpointConfig(endpoint, port);
    }

}
