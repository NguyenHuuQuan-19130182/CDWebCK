package com.erp.backend.controllers;

import com.erp.backend.entities.Product;
import com.erp.backend.entities.User;
import com.erp.backend.entities.Wishlist;
import com.erp.backend.repositories.ProductRepository;
import com.erp.backend.repositories.UserRepository;
import com.erp.backend.services.ProductService;
import com.erp.backend.services.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class WishlistController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WishlistService service;

    @GetMapping("/wishlist/{productId}/add")
    public ResponseEntity<?> addToWishlist(@PathVariable("productId") Long productId, @RequestAttribute("email")String email){
        return ResponseEntity.ok(service.addWishlist(productId,email));
    }

    @DeleteMapping ("/wishlist/{id}/remove")
    public void removeToWishlist(@PathVariable("id") long id) {
     service.removeWishlist(id);
    }
    @GetMapping("/wishlist/{userId}/getAll")
    public ResponseEntity<?> getAll(@PathVariable(value = "userId") long userId){
        return ResponseEntity.ok(service.getAllProToWishlist(userId));
    }
}
