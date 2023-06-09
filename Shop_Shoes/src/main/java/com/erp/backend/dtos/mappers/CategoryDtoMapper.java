package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.CategoryDto;
import com.erp.backend.entities.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryDtoMapper implements Function<Category, CategoryDto> {


    @Override
    public CategoryDto apply(Category category) {
        return new CategoryDto(category.getId_category(), category.getName(),category.getParent_id());
    }
}
