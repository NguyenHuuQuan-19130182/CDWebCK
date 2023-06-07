package com.erp.backend.services;


import com.erp.backend.dtos.CartDto;
import com.erp.backend.dtos.mappers.CartDtoMapper;
import com.erp.backend.dtos.request.CartRequest;
import com.erp.backend.entities.Cart;
import com.erp.backend.entities.Product;
import com.erp.backend.entities.User;
import com.erp.backend.repositories.CartRepository;
import com.erp.backend.repositories.ProductRepository;
import com.erp.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartDtoMapper mapper;

    public CartDto addCart(Long productID,String email,CartRequest request) {
        Product product = productRepository.findById(productID).get();
        User user = userRepository.findByEmail(email).get();
        Cart cart = Cart.builder()
                .product(product)
                .user(user)
                .size(request.getSize())
                .quantity(request.getQuantity())
                .build();
        Cart save = cartRepository.save(cart);
       return mapper.apply(save);
    }

    public void removeCart(long id) {
        cartRepository.deleteById(id);
    }


    public List<CartDto> getAllProToCartByUser(long user_id) {
        List<Cart> list = cartRepository.findByUser(user_id);
        List<CartDto> cartDtos = list.stream().map(mapper::apply).collect(Collectors.toList());
        return cartDtos;
    }
}
