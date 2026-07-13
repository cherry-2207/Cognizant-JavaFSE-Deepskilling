package com.example.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/products")
public class ProductController {

    @Value("${message:Hello local}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }

    @GetMapping
    public List<String> getProducts() {
        return Arrays.asList("Laptop", "Smartphone", "Headphones");
    }
}
