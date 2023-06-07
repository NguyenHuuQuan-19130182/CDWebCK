package com.erp.backend.dtos;

public record OrderDetailDto(long id, OrderDto orderDto,ProductDto product,int quantity,int size,double total,String note) {
}
