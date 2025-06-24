package com.projects.businesstock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.businesstock.domain.product.Product;
import com.projects.businesstock.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/products")
@Tag(name = "product", description = "Controller to return, insert, update and delete a Product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    @Operation(summary = "Return all products", description = "Method to return all the products")
    @ApiResponse(responseCode = "200", description = "List of all products")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Insert a product", description = "Method to insert a product")
    @ApiResponse(responseCode = "201", description = "Product registered")
    @ApiResponse(responseCode = "400", description = "Data sent in the request body is invalid")
    @ApiResponse(responseCode = "409", description = "Product already registered")
    @ApiResponse(responseCode = "500", description = "Server error")
    @PostMapping
    public Product insertProduct(@RequestBody Product p) {
        return service.insertProduct(p);
    }
    
    @Operation(summary = "Edit a product", description = "Method to edit a product")
    @ApiResponse(responseCode = "204", description = "Product edited")
    @ApiResponse(responseCode = "400", description = "Data sent for update is invalid or incomplete")
    @ApiResponse(responseCode = "404", description = "Product id not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product p) {
        p = service.updateProduct(id, p);
        return ResponseEntity.ok().body(p);
    }

    @Operation(summary = "Delete a product", description = "Method to delete a product")
    @ApiResponse(responseCode = "204", description = "Product deleted")
    @ApiResponse(responseCode = "404", description = "Product id not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}