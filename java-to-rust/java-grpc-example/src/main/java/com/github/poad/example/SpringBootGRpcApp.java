package com.github.poad.example;

import com.github.poad.example.grpc.client.config.EndpointConfig;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class SpringBootGRpcApp extends SpringBootServletInitializer implements HealthIndicator {
    public static void main( String... args ) {
        new SpringBootGRpcApp()
                .configure(new SpringApplicationBuilder(SpringBootGRpcApp.class))
                .run(args);
    }

    @Bean
    public EndpointConfig gRpcEndpoint() {
        Map<String, String> env = System.getenv();
        String endpoint = env.getOrDefault("GRPC_ENDPOINT", "127.0.0.1");
        int port = Optional.ofNullable(env.get("GRPC_ENDPOINT_PORT"))
                .map(Integer::valueOf).orElse(50051);
        return new EndpointConfig(endpoint, port);
    }

    @Override
    public Health health() {
        return Health.up().withDetail("health", true).build();
    }
}
