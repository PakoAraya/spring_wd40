package com.example.supabase.service;

import com.example.supabase.entity.Product;
import com.example.supabase.repository.IProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** Service class to manage business logic for Product operations. */
@Service
public class ProductService {

  private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

  @Autowired
  private IProductRepository productRepository;

  /** Retrieves all products from the database. */
  public List<Product> findAllProducts() {
    logger.info("Fetching all products");
    List<Product> products = productRepository.findAll();
    logger.info("Total products retrieved: {}", products.size());
    return products;
  }

  /** Saves a new product or updates an existing one. */
  public Product saveProduct(Product product) {
    logger.info("Saving product: {}", product.getName());
    Product savedProduct = productRepository.save(product);
    logger.info("Product saved successfully with ID: {}", savedProduct.getId());
    return savedProduct;
  }

  /** Deletes a product by its unique ID. */
  public void deleteProductById(Long id) {
    logger.warn("Attempting to delete product with ID: {}", id);
    // Optional: Check if it exists before deleting to avoid errors
    if (productRepository.existsById(id)) {
      productRepository.deleteById(id);
      logger.info("Product with ID: {} deleted successfully", id);
    } else {
      logger.error("Cannot delete. Product with ID: {} NOT FOUND", id);
    }
  }

  /** Finds a product by its ID. */
  public Optional<Product> findProductById(Long id) {
    logger.info("Searching for product with ID: {}", id);
    Optional<Product> product = productRepository.findById(id);

    if (product.isPresent()) {
      logger.info("Product found: {}", product.get().getName());
    } else {
      logger.error("Product with ID: {} NOT FOUND", id);
    }

    return product;
  }

  public List<Product> findProductsByCategory(String category) {
    logger.info("Searching products by category: {}", category);
    // Call the fixed repository method
    return productRepository.findByCategory(category);
  }

  /** Finds products by name (case-insensitive search). */
  public List<Product> findProductsByName(String name) {
    logger.info("Searching products containing: {}", name);
    return productRepository.findByNameContainingIgnoreCase(name);
  }

}