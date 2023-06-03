package com.erp.backend.services;


import com.erp.backend.dtos.CartDto;
import com.erp.backend.dtos.auth.CartDTO;
import com.erp.backend.dtos.mappers.CartDtoMapper;
import com.erp.backend.dtos.request.CartRequest;
import com.erp.backend.entities.Cart;
import com.erp.backend.entities.Size;
import com.erp.backend.entities.User;
import com.erp.backend.repositories.CartRepository;
import com.erp.backend.repositories.SizeRepository;
import com.erp.backend.repositories.UserRepository;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartDtoMapper mapper;

    public Cart addProToCart(CartDTO cartDto){
        Cart cart = new Cart();
        Size size = sizeRepository.findById(cartDto.getSize()).get();
        User user = userRepository.findById(cartDto.getUser()).get();
        cart.setSize(size);
        cart.setUser(user);
        cart.setQuantity(cartDto.getQuantity());

        return cartRepository.save(cart);
    }
    public CartDto addCart( @Valid CartRequest request){
        User user = userRepository.findById(request.getUser()).get();
        Size size = sizeRepository.findById(request.getSize()).get();

        Cart cart = Cart.builder()
                .user(user).size(size).quantity(request.getQuantity()).build();
        Cart save = cartRepository.save(cart);
        return mapper.apply(save);
    }
    public void removeCart(long id){
      cartRepository.deleteById(id);
    }


    public List<CartDto> getAllProToCartByUser(long user_id){
        List<Cart> list = cartRepository.findByUser(user_id);
        List<CartDto> cartDtos = list.stream().map(mapper::apply).collect(Collectors.toList());
        return cartDtos;
    }
}
