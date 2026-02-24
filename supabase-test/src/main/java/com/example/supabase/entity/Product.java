package com.example.supabase.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

//Entity representing the 'products' table in the database.
@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String category;

  // Using BigDecimal for financial precision instead of Double
  @Column(precision = 10, scale = 2)
  private BigDecimal price;

  // Default constructor required by JPA
  public Product() {
  }

  // Parameterized constructor for easy object creation
  public Product(String name, String category, BigDecimal price) {
    this.name = name;
    this.category = category;
    this.price = price;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
  }
}