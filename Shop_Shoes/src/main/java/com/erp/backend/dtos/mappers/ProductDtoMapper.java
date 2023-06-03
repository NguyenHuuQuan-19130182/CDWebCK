package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.CategoryDto;
import com.erp.backend.dtos.ProductDto;
import com.erp.backend.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductDtoMapper implements Function<Product, ProductDto> {
    @Autowired
    CategoryDtoMapper categoryDtoMapper;
    @Override
    public ProductDto apply(Product product) {
        CategoryDto categoryDto = categoryDtoMapper.apply(product.getCategory());

        return new ProductDto(product.getId(), product.getName(), categoryDto, product.getPrice(), product.getSellPrice(), product.getImg(), product.getQuantity(),product.getListComment());
    }
}
