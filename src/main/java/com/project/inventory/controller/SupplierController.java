package com.project.inventory.controller;

import com.project.inventory.entity.Supplier;
import com.project.inventory.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {


private final SupplierService supplierService;


public SupplierController(SupplierService supplierService) {
this.supplierService = supplierService;
}


@PostMapping
public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
return ResponseEntity.ok(supplierService.addSupplier(supplier));
}


@GetMapping
public ResponseEntity<List<Supplier>> getAllSuppliers() {
return ResponseEntity.ok(supplierService.getAllSuppliers());
}


@GetMapping("/{id}")
public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
return supplierService.getSupplierById(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}


@PutMapping("/{id}")
public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
return ResponseEntity.ok(supplierService.updateSupplier(id, supplier));
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
supplierService.deleteSupplier(id);
return ResponseEntity.noContent().build();
}
}
