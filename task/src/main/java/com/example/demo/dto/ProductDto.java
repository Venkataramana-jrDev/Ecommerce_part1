package com.example.demo.dto;

import java.math.BigDecimal;

import lombok.*;

@Data
@Builder
public class ProductDto {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String creationDate;

}

