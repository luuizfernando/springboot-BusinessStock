package com.projects.businesstock.domain.product;

public enum ProductCategory {

    ELETRONICS("eletronics"),
    SPORT("sport"),
    HOUSE("house"),
    FASHION("fashion");

    private String category;

    ProductCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
    
}