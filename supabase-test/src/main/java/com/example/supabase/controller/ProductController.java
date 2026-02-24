package com.example.supabase.controller;

import com.example.supabase.entity.Product;
import com.example.supabase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** REST Controller to expose Product API endpoints. */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  /** GET /api/v1/products : Get all products. */
  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    // Calling the specific method name we defined in the service
    return ResponseEntity.ok(productService.findAllProducts());
  }

  /** GET /api/v1/products/{id} : Get a product by ID. */
  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    // Handling Optional: return 200 OK if found, or 404 Not Found if empty
    return productService.findProductById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/category/{categoryName}")
  public ResponseEntity<List<Product>> findByCategory(@PathVariable String categoryName) {
    return ResponseEntity.ok(productService.findProductsByCategory(categoryName));
    // (Tendrías que añadir este método pequeñito en el Service)
  }

  /** GET /api/v1/products/search?name=... : Search products by name. */
  @GetMapping("/search")
  public ResponseEntity<List<Product>> findByName(@RequestParam String name) {
    return ResponseEntity.ok(productService.findProductsByName(name));
  }

  /** POST /api/v1/products : Create a new product. */
  @PostMapping
  public ResponseEntity<Product> save(@RequestBody Product product) {
    // Calling the specific method name from the service
    return ResponseEntity.ok(productService.saveProduct(product));
  }

  /** DELETE /api/v1/products/{id} : Delete a product by ID. */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    // Logic to check existence before deleting could be added here
    productService.deleteProductById(id);
    return ResponseEntity.noContent().build();
  }
}