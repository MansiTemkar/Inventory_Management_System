package com.project.inventory.controller;

import com.project.inventory.entity.OrderEntity;
import com.project.inventory.entity.OrderStatus;
import com.project.inventory.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {


private final OrderService orderService;


public OrderController(OrderService orderService) {
this.orderService = orderService;
}


@PostMapping
public ResponseEntity<OrderEntity> placeOrder(@RequestBody OrderEntity order) {
return ResponseEntity.ok(orderService.placeOrder(order));
}


@GetMapping
public ResponseEntity<List<OrderEntity>> getAllOrders() {
return ResponseEntity.ok(orderService.getAllOrders());
}


@GetMapping("/{id}")
public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long id) {
return orderService.getOrderById(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}


@PutMapping("/{id}/status")
public ResponseEntity<OrderEntity> updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
return ResponseEntity.ok(orderService.updateOrderStatus(id, status));
}
}
