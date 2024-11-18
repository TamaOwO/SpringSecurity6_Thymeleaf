package com.example.springsecurity6_thymeleaf.service;

import com.example.springsecurity6_thymeleaf.entiry.Product;

import java.util.List;

public interface ProductServices {
    void delete(Long id);

    Product get(Long id);

    Product save(Product product);
    List<Product> listAll();
}
