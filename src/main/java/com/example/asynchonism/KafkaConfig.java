package com.example.asynchonism;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name("cluster-topic")
                .partitions(3)
                .replicas(3)
                .build();
    }
}
