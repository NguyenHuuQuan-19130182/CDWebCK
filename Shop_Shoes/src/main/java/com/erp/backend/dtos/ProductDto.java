package com.erp.backend.dtos;

import com.erp.backend.entities.Review;
import com.erp.backend.entities.User;

import java.util.List;

public record ProductDto(Long id, String name, CategoryDto category, double price,
                         double sellPrice, String img, Integer quantity, List<Review> lstReview) {
}
