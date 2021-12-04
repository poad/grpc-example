package com.github.poad.example.service;

import com.github.poad.example.model.Hello;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Valid
@Service
public interface HelloService {

    Optional<Hello> sayHello(@NotBlank String name);
}
