package com.example.inventory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Value("${message:Hello local}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }

    @GetMapping
    public Map<String, Integer> getInventory() {
        Map<String, Integer> stock = new HashMap<>();
        stock.put("Laptop", 15);
        stock.put("Smartphone", 50);
        stock.put("Headphones", 120);
        return stock;
    }
}
