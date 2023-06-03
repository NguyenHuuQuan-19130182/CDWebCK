package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.CartDto;
import com.erp.backend.dtos.SizeDto;
import com.erp.backend.dtos.UserDto;
import com.erp.backend.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CartDtoMapper implements Function<Cart, CartDto> {
    @Autowired
    private  SizeDtoMapper sizeDtoMapper;
    @Autowired
    private UserDTOMapper userDTOMapper;
    @Override
    public CartDto apply(Cart cart) {
        SizeDto size = sizeDtoMapper.apply(cart.getSize());
        UserDto user = userDTOMapper.apply(cart.getUser());
        return new CartDto(cart.getId(),size,user,cart.getQuantity());
    }
}
