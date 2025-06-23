package com.projects.businesstock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.businesstock.domain.product.Product;
import com.projects.businesstock.domain.product.ProductCategory;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(ProductCategory category);
    
}