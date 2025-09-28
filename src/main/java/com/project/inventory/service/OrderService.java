package com.project.inventory.service;

import com.project.inventory.entity.OrderEntity;
import com.project.inventory.entity.OrderStatus;
import com.project.inventory.entity.Product;
import com.project.inventory.repository.OrderRepository;
import com.project.inventory.repository.ProductRepository;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class OrderService {


private final OrderRepository orderRepository;
private final ProductRepository productRepository;


public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
this.orderRepository = orderRepository;
this.productRepository = productRepository;
}


public OrderEntity placeOrder(OrderEntity order) {
Product product = productRepository.findById(order.getProductId())
.orElseThrow(() -> new RuntimeException("Product not found"));


if (product.getStockQuantity() < order.getQuantity()) {
throw new RuntimeException("Not enough stock available");
}


// reduce stock
product.setStockQuantity(product.getStockQuantity() - order.getQuantity());
productRepository.save(product);


order.setStatus("PENDING");
return orderRepository.save(order);
}


public List<OrderEntity> getAllOrders() {
return orderRepository.findAll();
}


public Optional<OrderEntity> getOrderById(Long id) {
return orderRepository.findById(id);
}


public OrderEntity updateOrderStatus(Long id, OrderStatus status) {
return orderRepository.findById(id).map(order -> {
order.setStatus(status);
return orderRepository.save(order);
}).orElseThrow(() -> new RuntimeException("Order not found"));
}
}
