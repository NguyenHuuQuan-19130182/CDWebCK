package com.erp.backend.controllers;

import com.erp.backend.dtos.auth.ProductDTO;
import com.erp.backend.dtos.auth.SearchDto;
import com.erp.backend.entities.Product;
import com.erp.backend.services.ProductService;
import com.erp.backend.services.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SizeService sizeService;

    @PostMapping("/product/create")
    public Product createProduct(@RequestBody @Valid ProductDTO dto){
        return productService.createProduct(dto);
    }
    @GetMapping("/product")
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/product/category/{categoryId}")
    public ResponseEntity<?> productByCategory(@PathVariable(value = "categoryId") Long categoryId){
        return ResponseEntity.ok(productService.getListByCategory(categoryId));
    }

    @GetMapping("/product/category/{parentId}")
    public ResponseEntity<?> productByParent(@PathVariable(value = "parentId") Long parentId){
        return ResponseEntity.ok(productService.getLstProductParentId(parentId));
    }

    @PostMapping("/product/search")
    public ResponseEntity<?> search(@RequestBody SearchDto key){
        return ResponseEntity.ok(productService.search(key));
    }

    @GetMapping("/products/{productId}/info-product")
    public ResponseEntity<?> info(@PathVariable(value = "productId") long productId){
        return ResponseEntity.ok(sizeService.getInfoProduct(productId));
    }

    @GetMapping("/product/page")
    public ResponseEntity<?> getAllPageArticle(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(productService.getAllProductPage(page,size));
    }

}
