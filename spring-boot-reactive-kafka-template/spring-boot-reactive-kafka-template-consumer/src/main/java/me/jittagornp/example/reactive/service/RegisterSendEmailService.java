package me.jittagornp.example.reactive.service;

import me.jittagornp.example.reactive.model.RegisterRequest;
import reactor.core.publisher.Mono;

public interface RegisterSendEmailService {

    Mono<Void> send(final RegisterRequest registerRequest);

}
