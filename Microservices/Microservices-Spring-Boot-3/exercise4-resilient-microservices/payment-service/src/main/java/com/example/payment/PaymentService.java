package com.example.payment;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackPayment")
    public String processPayment(double amount) {
        logger.info("Attempting to call third-party payment gateway for amount: {}", amount);
        
        // Simulating a slow/unstable external payment gateway
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount: " + amount);
        }
        
        // Artificially calling a slow service to simulate lag/timeout
        String url = "https://httpbin.org/delay/5"; 
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackPayment(double amount, Throwable throwable) {
        logger.warn("Circuit Breaker active! Fallback execution for payment of {}. Reason: {}", 
                amount, throwable.getMessage());
        return "Payment gateway is currently down. Fallback processed for amount: $" + amount;
    }
}
