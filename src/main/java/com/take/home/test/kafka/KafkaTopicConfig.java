package com.take.home.test.kafka;

import com.take.home.test.model.KafkaTopicsEnum;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic eventOutcomesTopic() {
        return TopicBuilder.name(KafkaTopicsEnum.EVENT_OUTCOMES.getTopicName())
                .partitions(3)
                .replicas(1)      
                .build();
    }
}