package com.project.inventory.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
public class OrderEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private Long productId;
private Integer quantity;
private LocalDateTime orderDate;


@Enumerated(EnumType.STRING)
private OrderStatus status;


public OrderEntity() {}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public Long getProductId() { return productId; }
public void setProductId(Long productId) { this.productId = productId; }


public Integer getQuantity() { return quantity; }
public void setQuantity(Integer quantity) { this.quantity = quantity; }


public LocalDateTime getOrderDate() { return orderDate; }
public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }


public OrderStatus getStatus() { return status; }
public void setStatus(OrderStatus status) { this.status = status; }


public void setStatus(String string) {
	// TODO Auto-generated method stub
	
}
}
