package com.example.TestJunit.repository;

import com.example.TestJunit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
