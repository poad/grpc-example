package com.github.poad.example.java.grpc.controller;

import com.github.poad.example.java.grpc.model.Hello;
import com.github.poad.example.java.grpc.service.HelloService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

    private final HelloService service;

    HelloController(@Autowired HelloService service) {
        this.service = service;
    }

    @GetMapping
    public Hello sayHello(@NotBlank String name) {
        return service.sayHello(name).orElseThrow();
    }

}
