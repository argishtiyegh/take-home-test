package com.take.home.test.kafka;

import com.take.home.test.model.EventOutcome;

public interface EventProducer {
    void publishEvent(EventOutcome eventOutcome);
}