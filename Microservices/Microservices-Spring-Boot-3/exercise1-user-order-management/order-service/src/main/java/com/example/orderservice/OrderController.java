package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient webClient;

    @Value("${user-service.url}")
    private String userServiceUrl;

    @PostMapping
    public Mono<ResponseEntity<Order>> createOrder(@RequestBody Order order) {
        // Call User Service using WebClient to verify user exists
        return webClient.get()
                .uri(userServiceUrl + "/users/" + order.getUserId())
                .retrieve()
                .bodyToMono(UserDto.class)
                .map(user -> {
                    Order savedOrder = orderRepository.save(order);
                    return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
                })
                .onErrorReturn(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
