package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.ProductDto;
import com.erp.backend.dtos.UserDto;
import com.erp.backend.dtos.WishlistDto;
import com.erp.backend.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class WishlistDtoMapper implements Function<Wishlist, WishlistDto> {
    @Autowired
    private  ProductDtoMapper productDtoMapper;
    @Autowired
    private UserDTOMapper userDTOMapper;

    @Override
    public WishlistDto apply(Wishlist wishlist) {
        ProductDto product =productDtoMapper.apply(wishlist.getProduct());
        UserDto user = userDTOMapper.apply(wishlist.getUser());
        return new WishlistDto(wishlist.getId(),product,user);
    }
}
