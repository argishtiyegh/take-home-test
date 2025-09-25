package com.take.home.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long betId;
    private Long userId;
    private Long eventId;
    private Long eventMarketId;
    private Long eventWinnerId;
    private Double betAmount;

    public BetEntity(Long userId, Long eventId, Long eventMarketId, Long eventWinnerId, Double betAmount) {
        this.userId = userId;
        this.eventId = eventId;
        this.eventMarketId = eventMarketId;
        this.eventWinnerId = eventWinnerId;
        this.betAmount = betAmount;
    }

    public BetEntity() {
        
    }

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventMarketId() {
        return eventMarketId;
    }

    public void setEventMarketId(Long eventMarketId) {
        this.eventMarketId = eventMarketId;
    }

    public Long getEventWinnerId() {
        return eventWinnerId;
    }

    public void setEventWinnerId(Long eventWinnerId) {
        this.eventWinnerId = eventWinnerId;
    }

    public Double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }
}
