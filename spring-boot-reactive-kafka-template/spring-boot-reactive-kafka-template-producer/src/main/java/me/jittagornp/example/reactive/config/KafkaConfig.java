package me.jittagornp.example.reactive.config;

import me.jittagornp.example.reactive.model.RegisterRequest;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.kafka.sender.SenderOptions;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ReactiveKafkaProducerTemplate<String, RegisterRequest> reactiveKafkaProducerTemplate(final KafkaProperties properties) {
        final Map<String, Object> props = properties.buildProducerProperties();
        return new ReactiveKafkaProducerTemplate<String, RegisterRequest>(SenderOptions.create(props));
    }

}
