package me.jittagornp.example.reactive.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jittagornp.example.reactive.model.RegisterRequest;
import me.jittagornp.example.reactive.service.RegisterSendEmailService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterConsumer implements CommandLineRunner {

    private final ReactiveKafkaConsumerTemplate<String, RegisterRequest> reactiveKafkaConsumerTemplate;

    private final RegisterSendEmailService registerSendEmailService;

    @Override
    public void run(final String... args) throws Exception {
        reactiveKafkaConsumerTemplate.receiveAutoAck()
                .flatMap(record -> registerSendEmailService.send(record.value()))
                .subscribe();
    }

}
