package com.take.home.test.controller;

import com.take.home.test.kafka.EventOutcomeProducer;
import com.take.home.test.model.EventOutcome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/event")
public class EventOutcomeController {

    final EventOutcomeProducer eventOutcomeProducer;

    public EventOutcomeController(EventOutcomeProducer eventOutcomeProducer) {
        this.eventOutcomeProducer = eventOutcomeProducer;
    }

    @PostMapping(path = "/outcomes")
    public void publishEvent() {
        // mock some event object
        EventOutcome eventOutcomeDummy = new EventOutcome(
                1234L, "P1", 2001L);
        eventOutcomeProducer.publishEvent(eventOutcomeDummy);
    }
}
