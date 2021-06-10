package me.jittagornp.example.reactive.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jittagornp.example.reactive.model.RegisterRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterSendEmailServiceImpl implements RegisterSendEmailService {

    @Override
    public Mono<Void> send(final RegisterRequest registerRequest) {
        return Mono.fromRunnable(() -> {
            log.info("Send email to {}", registerRequest.getEmail());
        });
    }
}
