package me.jittagornp.example.reactive.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jittagornp.example.reactive.model.RegisterRequest;
import me.jittagornp.example.reactive.model.RegisterResponse;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private static final String KAFKA_TOPIC_NAME = "register-user";

    private final ReactiveKafkaProducerTemplate<String, RegisterRequest> reactiveKafkaProducerTemplate;

    @Override
    public Mono<RegisterResponse> register(final RegisterRequest registerRequest) {
        registerRequest.setId(UUID.randomUUID());
        return reactiveKafkaProducerTemplate.send(KAFKA_TOPIC_NAME, registerRequest)
                .map(result -> {
                    log.info("Send request {} to kafka success", registerRequest.getId());
                    return RegisterResponse.builder()
                            .id(registerRequest.getId())
                            .build();
                });
    }
}
