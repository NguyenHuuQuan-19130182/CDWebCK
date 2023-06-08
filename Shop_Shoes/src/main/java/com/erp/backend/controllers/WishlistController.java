package com.erp.backend.controllers;

import com.erp.backend.entities.Product;
import com.erp.backend.entities.Wishlist;
import com.erp.backend.repositories.ProductRepository;
import com.erp.backend.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class WishlistController {
    @Autowired
    private ProductRepository productRepository;

    private List<Wishlist> wishlists = new ArrayList<>();

    @GetMapping("/wishlist/{productId}/add")
    public Wishlist addToWishlist(@PathVariable("productId") Long productId){
        Product product = productRepository.findById(productId).get();
        Wishlist wishlist = new Wishlist();

        wishlist.setId(product.getId());
        wishlist.setImg(product.getImg());
        wishlist.setName(product.getName());
        wishlist.setPrice(product.getPrice());
        wishlist.setSellPrice(product.getSellPrice());

        wishlists.add(wishlist);

        return wishlist;
    }

    @GetMapping("/wishlist/{productId}/remove")
    public ResponseEntity<?> removeToWishlist(@PathVariable("productId") long productId) {
        Product product = productRepository.findById(productId).get();

        // Tìm kiếm sản phẩm trong danh sách Wishlist theo id
        Optional<Wishlist> item = wishlists.stream().filter(items -> items.getId() == productId).findFirst();
        // Nếu sản phẩm tồn tại trong danh sách, xóa nó khỏi danh sách
        item.ifPresent(wishlists::remove);

        return ResponseEntity.ok("Xóa thành công");
    }
}
