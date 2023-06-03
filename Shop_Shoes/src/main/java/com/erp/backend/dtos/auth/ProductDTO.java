package com.erp.backend.dtos.auth;

import lombok.Data;

@Data
public class ProductDTO {
    private Long idCategory;
    private String name;
    private double price;
    private double sellPrice;
    private String img;
    private int quantity;
}
