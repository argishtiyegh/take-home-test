package com.take.home.test.model;

public enum KafkaTopicsEnum {
    EVENT_OUTCOMES("event-outcomes");
    
    private final String topicName;

    KafkaTopicsEnum(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
