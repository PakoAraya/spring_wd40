package com.example.supabase.repository;

import com.example.supabase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
  // Custom query method example: Find products by category
  List<Product> findByCategory(String category);

  /** Find products by name containing a string.
   * SQL: SELECT * FROM products WHERE name LIKE %?% */
  List<Product> findByNameContainingIgnoreCase(String name);

}
