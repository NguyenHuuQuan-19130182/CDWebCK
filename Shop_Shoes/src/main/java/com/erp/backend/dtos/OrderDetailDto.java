package com.erp.backend.dtos;

public record OrderDetailDto(long id, OrderDto orderDto,SizeDto sizeDto,int quantity,double price,double total,String note) {
}
