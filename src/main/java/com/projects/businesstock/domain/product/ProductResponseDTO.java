package com.projects.businesstock.domain.product;

public record ProductResponseDTO(String id, String name, Double price, ProductCategory category) {
    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getCategory());
    }
}