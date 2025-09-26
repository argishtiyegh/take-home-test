# Take Home Test Application

## Overview
This is a **Spring Boot application** that demonstrates a simple event-driven workflow using **Kafka** and an **H2 in-memory database**. The application allows publishing `EventOutcome` events to a Kafka topic, which are then consumed to check for related bets in the database.

---

## Features
- Spring Boot REST API to publish `EventOutcome` events.
- Kafka integration with producer and consumer.
- H2 in-memory database pre-populated with sample BET records on startup.
- Logging of successful event processing when a related BET record is found.
- Kafka UI available for monitoring topics and messages.

---

## Running the Application

### Prerequisites
- Docker
- Docker Compose

### Build Docker Images
```bash
docker compose build

docker compose up -d

```

## Access the Application

Spring Boot API: http://localhost:8080

Kafka UI: http://localhost:8081

## API USAGE

```

curl -X POST http://localhost:8080/api/v1/event/outcomes

docker ps // to get container ID for take-home-test_springboot-app

docker logs [CONTAINER_ID] // view the logs for tracking the events behavior.

```
### Stop the docker containers, run 
```
docker compose stop
