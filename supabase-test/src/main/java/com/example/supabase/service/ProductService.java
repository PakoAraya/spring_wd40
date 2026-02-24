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
  public List<Product> findAll() {
    logger.info("Fetching all products");
    List<Product> products = productRepository.findAll();
    logger.info("Total products retrieved: {}", products.size());
    return products;
  }

  /** Saves a new product or updates an existing one. */
  public Product save(Product product) {
    logger.info("Saving product: {}", product.getName());
    Product savedProduct = productRepository.save(product);
    logger.info("Product saved successfully with ID: {}", savedProduct.getId());
    return savedProduct;
  }

  /** Deletes a product entity. */
  public void delete(Product product) {
    logger.warn("Deleting product entity: {}", product);
    productRepository.delete(product);
    logger.info("Product deleted successfully");
  }

  /** Deletes a product by its unique ID. */
  public void deleteById(Long id) {
    logger.warn("Attempting to delete product with ID: {}", id);
    productRepository.deleteById(id);
    logger.info("Deletion command executed for ID: {}", id);
  }

  /** Finds a product by its ID. */
  public Optional<Product> findById(Long id) {
    logger.info("Searching for product with ID: {}", id);
    Optional<Product> product = productRepository.findById(id);

    if (product.isPresent()) {
      logger.info("Product found: {}", product.get().getName());
    } else {
      logger.error("Product with ID: {} NOT FOUND", id);
    }

    return product;
  }
}