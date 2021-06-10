/*
 * Copyright 2019-Current jittagornp.me
 */
package me.jittagornp.example.reactive.controller;

import lombok.RequiredArgsConstructor;
import me.jittagornp.example.reactive.model.RegisterRequest;
import me.jittagornp.example.reactive.model.RegisterResponse;
import me.jittagornp.example.reactive.service.RegisterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author jitta
 */
@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping({"", "/"})
    public Mono<String> hello() {
        return Mono.just("Hello kafka.");
    }

    @PostMapping("/register")
    public Mono<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        return registerService.register(registerRequest);
    }
}
