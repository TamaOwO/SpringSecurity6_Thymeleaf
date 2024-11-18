package com.example.springsecurity6_thymeleaf.service.impl;

import com.example.springsecurity6_thymeleaf.entiry.Product;
import com.example.springsecurity6_thymeleaf.repository.ProductRepository;
import com.example.springsecurity6_thymeleaf.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepository repo;

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Product get(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }
}
