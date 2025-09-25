package com.take.home.test.kafka;

import com.take.home.test.model.BetEntity;
import com.take.home.test.model.EventOutcome;
import com.take.home.test.repository.BettingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventOutcomeConsumer {
    private static final Logger logger = LoggerFactory.getLogger(EventOutcomeConsumer.class);

    final BettingRepository bettingRepository;

    public EventOutcomeConsumer(BettingRepository bettingRepository) {
        this.bettingRepository = bettingRepository;
    }

    @KafkaListener(
            topics = "event-outcomes", 
            groupId = "event-outcomes-consumers",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(EventOutcome eventData) {
        logger.info("Event received , with: " + eventData);
        // check if event exists in betting table
        List<BetEntity> betsByEventId = bettingRepository.findByEventId(eventData.eventId());
        
        if (betsByEventId.isEmpty()) {
            logger.warn("No bet found with provided event. eventId {}", eventData.eventId());
        } else {
            logger.info("The event found in db and should be settled, eventID {}", eventData.eventId());
        }
    }
}