package com.erp.backend.controllers;

import com.erp.backend.dtos.CartDto;
import com.erp.backend.dtos.auth.CartDTO;
import com.erp.backend.dtos.request.CartRequest;
import com.erp.backend.entities.Cart;
import com.erp.backend.entities.Size;
import com.erp.backend.entities.User;
import com.erp.backend.repositories.CartRepository;
import com.erp.backend.services.CartService;
import com.erp.backend.services.ProductService;
import com.erp.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

    @PostMapping(value = {"/add/prodcut"})
    public ResponseEntity<?> addCart( @Valid @RequestBody CartRequest request) {
        return ResponseEntity.ok(cartService.addCart(request));
    }

    @DeleteMapping("cart/remove/{cartId}")
//    public ResponseEntity<?> removeCart(@PathVariable(value = "cartId") long cartId){
//       return ResponseEntity.ok(cartService.removeCart(cartId));
//    }
    public void remove(@PathVariable(value = "cartId") long cartId){
        cartService.removeCart(cartId);
    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<?> getAllCartOfUser(@PathVariable(value = "userId") long userId){
        return ResponseEntity.ok(cartService.getAllProToCartByUser(userId));
    }
}
