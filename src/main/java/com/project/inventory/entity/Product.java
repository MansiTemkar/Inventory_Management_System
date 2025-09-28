package com.project.inventory.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "products")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String name;


@Column(length = 1000)
private String description;


private BigDecimal price;


private Integer stockQuantity;


// constructors, getters, setters
public Product() {}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public String getName() { return name; }
public void setName(String name) { this.name = name; }


public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }


public BigDecimal getPrice() { return price; }
public void setPrice(BigDecimal price) { this.price = price; }


public Integer getStockQuantity() { return stockQuantity; }
public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }
}
