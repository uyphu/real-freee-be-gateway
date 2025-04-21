# 🌐 Gateway Service — REAL FREEE Platform

The **Gateway Service** is the entry point for all client and backend communication within the REAL FREEE microservice architecture. It routes and filters HTTP requests to underlying services like `item-service`, `auth-service`, and more.

Built using **Spring Cloud Gateway**, it provides dynamic routing, request filtering, rate limiting, circuit breaking, and service discovery.

---

## 🚀 Features

- Intelligent routing for all microservices
- Path rewriting for clean APIs
- Integrated with Spring Cloud Discovery (Eureka-ready)
- Rate limiting with Redis
- Circuit breaking with Resilience4j
- Supports fallback handling
- Centralized logging & monitoring support

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.2
- Spring Cloud Gateway
- Resilience4j
- Redis (for rate limiting)
- Maven
- Docker (optional)

---

## 📁 Clone the Repository

```bash
git clone https://github.com/your-org/gateway-service.git
cd gateway-service
```
## ⚙️ Configuration
Update the routing rules in src/main/resources/application.yml:

```yaml


server:
  port: 8080

spring:
  application:
    name: gateway-service

  cloud:
    gateway:
      routes:
        - id: item-service
          uri: http://localhost:8081
          predicates:
            - Path=/item-service/api/**
          filters:
            - RewritePath=/item-service/api/(?<remaining>.*), /api/${remaining}
            - name: CircuitBreaker
              args:
                name: itemCB
                fallbackUri: forward:/fallback/item
            - name: RequestRateLimiter
              args:
                redis-rate-limiter:
                  replenishRate: 10
                  burstCapacity: 20
                  requestedTokens: 1
```
Add Redis and Resilience4j config as needed for local testing.

## 🔄 Example Routes

Path	Routed To
/item-service/api/items	http://localhost:8081/api/items
/auth-service/api/login	http://localhost:8083/api/login
/services/tool/...	Custom mapped with rewrite filters
🧪 Running the Gateway
## 🧰 Prerequisites
Java 17

Maven
Redis (for rate limiting) — optional

🧪 Start Gateway
```bash
./mvnw spring-boot:run
```
📎 Request Examples
```bash


# Call item-service via gateway
curl http://localhost:8080/item-service/api/items

# Call with a fallback path
curl http://localhost:8080/item-service/api/unknown
```
## 🧱 Redis for Rate Limiting
Start Redis via Docker:

```bash
docker run -d --name redis -p 6379:6379 redis
```
🧪 Running Tests
```bash
./mvnw test
```
## 📬 Contact
Maintainer: Phu Le
