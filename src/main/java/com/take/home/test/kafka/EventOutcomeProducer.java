package com.take.home.test.kafka;

import com.take.home.test.model.EventOutcome;
import com.take.home.test.model.KafkaTopicsEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EventOutcomeProducer implements EventProducer {

    private static final Logger logger = LoggerFactory.getLogger(EventOutcomeProducer.class);

    private final KafkaTemplate<String, EventOutcome> jsonKafkaTemplate;
    
    public EventOutcomeProducer(KafkaTemplate<String, EventOutcome> jsonKafkaTemplate) {
        this.jsonKafkaTemplate = jsonKafkaTemplate;
    }

    @Override
    public void publishEvent(EventOutcome eventOutcome) {
        logger.info("publishing event with id: " + eventOutcome.eventId());
        
        CompletableFuture<SendResult<String, EventOutcome>> future = jsonKafkaTemplate.send(
                KafkaTopicsEnum.EVENT_OUTCOMES.getTopicName(), eventOutcome
        );
        
        future.thenAccept(result -> {
            logger.info("Message published successfully to topic {}, partition {}, offset {}", 
                    result.getRecordMetadata().topic(),
                    result.getRecordMetadata().partition(),
                    result.getRecordMetadata().offset()
            );
        }).exceptionally(ex -> {
            logger.error("Failed to publish message: " + ex.getMessage());
            return null;
        });
    }
}
