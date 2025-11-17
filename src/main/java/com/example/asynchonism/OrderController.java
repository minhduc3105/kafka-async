package com.example.asynchonism;

import com.example.asynchonism.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        kafkaTemplate.send("cluster-topic", order);
        return "Order created " + order.getProductName() + " on Cluster!";
    }
}
