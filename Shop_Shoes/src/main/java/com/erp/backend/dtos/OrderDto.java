package com.erp.backend.dtos;

public record OrderDto(long id, ShipDto shipDto, UserDto userDto,PaymentDto paymentDto,String state,String note) {
}
