package com.github.poad.example.elixir.grpc;

import com.github.poad.example.elixir.grpc.client.EndpointConfig;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Map;
import java.util.Optional;

@SpringBootApplication(exclude = JpaRepositoriesAutoConfiguration.class)
@EnableScheduling
public class App extends SpringBootServletInitializer implements HealthIndicator {
    public static void main( String... args ) {
        new App()
                .configure(new SpringApplicationBuilder(App.class))
                .run(args);
    }

    @Bean(name={"default"})
    public EndpointConfig gRpcEndpoint() {
        Map<String, String> env = System.getenv();
        String endpoint = env.getOrDefault("GRPC_ENDPOINT", "127.0.0.1");
        int port = Optional.ofNullable(env.get("GRPC_ENDPOINT_PORT"))
                .map(Integer::valueOf).orElse(50051);
        return new EndpointConfig(endpoint, port);
    }

    @Bean(name={"hello"})
    public EndpointConfig helloGRpcEndpoint() {
        Map<String, String> env = System.getenv();
        String endpoint = env.getOrDefault("HELLO_GRPC_ENDPOINT", "127.0.0.1");
        int port = Optional.ofNullable(env.get("HELLO_GRPC_ENDPOINT_PORT"))
                .map(Integer::valueOf).orElse(50050);
        return new EndpointConfig(endpoint, port);
    }

    @Bean(name={"uuid"})
    public EndpointConfig uuidGRpcEndpoint() {
        String endpoint = System.getProperty("UUID_GRPC_ENDPOINT", "127.0.0.1");
        int port = Optional.ofNullable(System.getenv("UUID_GRPC_ENDPOINT_PORT"))
                .map(Integer::valueOf).orElse(50052);
        return new EndpointConfig(endpoint, port);
    }

    @Override
    public Health health() {
        return Health.up().withDetail("health", true).build();
    }
}
