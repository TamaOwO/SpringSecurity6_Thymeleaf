package com.example.springsecurity6_thymeleaf.repository;

import com.example.springsecurity6_thymeleaf.entiry.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
