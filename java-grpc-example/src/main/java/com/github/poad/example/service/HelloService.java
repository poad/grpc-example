package com.github.poad.example.service;

import com.github.poad.example.model.Hello;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Valid
@Service
public interface HelloService {

    Optional<Hello> sayHello(@NotBlank String name);
}
