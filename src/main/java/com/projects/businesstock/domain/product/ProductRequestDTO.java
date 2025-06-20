package com.projects.businesstock.domain.product;

import jakarta.validation.constraints.NotBlank;

public record ProductRequestDTO(

    @NotBlank
    String name, 
    
    ProductCategory category
    
)  {}