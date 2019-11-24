package com.github.poad.example.micronaut.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("com.github.poad.example.micronaut.grpc.repository")
@EnableTransactionManagement
public class App {
    public static void main( String... args ) {
        SpringApplication.run(App.class, args);
    }
}
