package com.erp.backend.controllers;

import com.erp.backend.dtos.request.CartRequest;
import com.erp.backend.dtos.request.UpdateCartRequest;
import com.erp.backend.entities.Cart;
import com.erp.backend.services.CartService;
import com.erp.backend.services.ProductService;
import com.erp.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = {"/add/product/{productId}"})
    public ResponseEntity<?> addCart(@PathVariable(value = "productId")Long productId,@RequestAttribute("email") String email
    ,@RequestBody CartRequest request) {
        return ResponseEntity.ok(cartService.addCart(productId,email,request));
    }

    @DeleteMapping("cart/remove/{cartId}")
    public void remove(@PathVariable(value = "cartId") long cartId){
        cartService.removeCart(cartId);
    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<?> getAllCartOfUser(@PathVariable(value = "userId") long userId) {
        return ResponseEntity.ok(cartService.getAllProToCartByUser(userId));
    }
    @PostMapping("/cart/update")
    public ResponseEntity<?> updateCart(@Valid @RequestBody UpdateCartRequest request){
        return ResponseEntity.ok(cartService.updateCart(request));
    }
}
