package com.erp.backend.controllers;

import com.erp.backend.dtos.request.ReviewRequest;
import com.erp.backend.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ReviewController {
    @Autowired
    ReviewService service;
    @PostMapping(value = {"/comment/create"})
    public ResponseEntity<?> createComment(@RequestAttribute("email") String email, @RequestBody ReviewRequest request){
        return  ResponseEntity.ok(service.creatReview(email,request));
    }
}
