package com.projects.businesstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.businesstock.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, String> {}