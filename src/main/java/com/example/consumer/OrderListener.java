package com.example.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {

    @KafkaListener(topics = "cluster-topic", groupId = "cluster-group")
    public void listen(Order order) {
        // Lúc này JSON đã biến lại thành Object Order
        System.out.println("---------------------------------");
        System.out.println("🔥 Đã nhận dữ liệu từ Cluster Kafka:");
        System.out.println("   - Mã đơn: " + order.getOrderId());
        System.out.println("   - Sản phẩm: " + order.getProductName());
        System.out.println("   - Giá: " + order.getPrice());
        System.out.println("---------------------------------");
    }
}