package me.jittagornp.example.reactive.service;

import me.jittagornp.example.reactive.model.RegisterRequest;
import me.jittagornp.example.reactive.model.RegisterResponse;
import reactor.core.publisher.Mono;

public interface RegisterService {

    Mono<RegisterResponse> register(final RegisterRequest registerRequest);

}
