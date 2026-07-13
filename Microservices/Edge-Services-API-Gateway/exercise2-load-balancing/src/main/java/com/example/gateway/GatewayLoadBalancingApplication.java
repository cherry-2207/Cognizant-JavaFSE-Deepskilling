package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;

@SpringBootApplication
@LoadBalancerClients(defaultConfiguration = LoadBalancerConfiguration.class)
public class GatewayLoadBalancingApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayLoadBalancingApplication.class, args);
    }
}
