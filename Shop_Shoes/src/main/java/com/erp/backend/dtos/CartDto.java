package com.erp.backend.dtos;

public record CartDto(long id,ProductDto product,UserDto user,int quantity) {
}
