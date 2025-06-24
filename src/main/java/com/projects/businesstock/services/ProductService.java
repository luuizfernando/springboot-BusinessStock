package com.projects.businesstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.businesstock.domain.product.Product;
import com.projects.businesstock.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product insertProduct(Product p) {
        return repository.save(p);
    }
        
}