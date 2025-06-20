package com.projects.businesstock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.businesstock.domain.product.Product;
import com.projects.businesstock.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
}