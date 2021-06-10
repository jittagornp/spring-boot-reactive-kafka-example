package me.jittagornp.example.reactive.config;

import me.jittagornp.example.reactive.model.RegisterRequest;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.Collections;

@Configuration
public class KafkaConfig {

    private static final String KAFKA_TOPIC_NAME = "register-user";

    @Bean
    public ReceiverOptions<String, RegisterRequest> kafkaReceiverOptions(final KafkaProperties kafkaProperties) {
        final ReceiverOptions<String, RegisterRequest> options = ReceiverOptions.create(kafkaProperties.buildConsumerProperties());
        return options.subscription(Collections.singletonList(KAFKA_TOPIC_NAME));
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, RegisterRequest> reactiveKafkaConsumerTemplate(final ReceiverOptions<String, RegisterRequest> kafkaReceiverOptions) {
        return new ReactiveKafkaConsumerTemplate<String, RegisterRequest>(kafkaReceiverOptions);
    }

}
