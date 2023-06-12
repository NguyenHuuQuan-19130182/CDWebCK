package com.erp.backend.services;

import com.erp.backend.dtos.WishlistDto;
import com.erp.backend.dtos.mappers.WishlistDtoMapper;
import com.erp.backend.entities.Product;
import com.erp.backend.entities.User;
import com.erp.backend.entities.Wishlist;
import com.erp.backend.repositories.ProductRepository;
import com.erp.backend.repositories.UserRepository;
import com.erp.backend.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  WishlistRepository repository;
    @Autowired
    private WishlistDtoMapper mapper;

    public WishlistDto addWishlist(Long productID,String email){
        Product product = productRepository.findById(productID).get();
        User user = userRepository.findByEmail(email).get();
        Wishlist wishlist = Wishlist.builder().product(product).user(user).build();
        Wishlist save = repository.save(wishlist);
        return mapper.apply(save);
    }

    public void removeWishlist(long id) {
        repository.deleteById(id);
    }
    public List<WishlistDto> getAllProToWishlist(long userId){
        List<Wishlist> list = repository.findByUser(userId);
        List<WishlistDto> dtos= list.stream().map(mapper::apply).collect(Collectors.toList());
        return dtos;
    }
}
