package com.project.inventory.controller;

import com.project.inventory.entity.Product;
import com.project.inventory.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {


private final ProductService productService;


public ProductController(ProductService productService) {
this.productService = productService;
}


@PostMapping
public ResponseEntity<Product> addProduct(@RequestBody Product product) {
return ResponseEntity.ok(productService.addProduct(product));
}


@GetMapping
public ResponseEntity<List<Product>> getAllProducts() {
return ResponseEntity.ok(productService.getAllProducts());
}


@GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable Long id) {
return productService.getProductById(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}


@PutMapping("/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
return ResponseEntity.ok(productService.updateProduct(id, product));
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
productService.deleteProduct(id);
return ResponseEntity.noContent().build();
}
}
