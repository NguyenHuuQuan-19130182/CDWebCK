package com.erp.backend.dtos;

public record CartDto(long id,SizeDto size,UserDto user,int quantity) {
}
