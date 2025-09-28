package com.project.inventory.service;

import com.project.inventory.entity.Product;
import com.project.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ProductService {


private final ProductRepository productRepository;


public ProductService(ProductRepository productRepository) {
this.productRepository = productRepository;
}


public Product addProduct(Product product) {
return productRepository.save(product);
}


public List<Product> getAllProducts() {
return productRepository.findAll();
}


public Optional<Product> getProductById(Long id) {
return productRepository.findById(id);
}


public Product updateProduct(Long id, Product updatedProduct) {
return productRepository.findById(id).map(product -> {
product.setName(updatedProduct.getName());
product.setDescription(updatedProduct.getDescription());
product.setPrice(updatedProduct.getPrice());
product.setStockQuantity(updatedProduct.getStockQuantity());
return productRepository.save(product);
}).orElseThrow(() -> new RuntimeException("Product not found"));
}


public void deleteProduct(Long id) {
productRepository.deleteById(id);
}
}