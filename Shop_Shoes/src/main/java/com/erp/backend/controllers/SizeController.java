package com.erp.backend.controllers;

import com.erp.backend.dtos.request.SizeRequest;
import com.erp.backend.services.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class SizeController {
    @Autowired
    private SizeService service;


    @PostMapping("/size/create")
//    public Size createSize(@RequestBody @Valid SizeDTO dto){
//        return service.createSize(dto);
//    }
    public ResponseEntity<?> createSize(@Valid @RequestBody SizeRequest request){
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/size/getAll")
    public  ResponseEntity<?> getAllSize(){
        return ResponseEntity.ok(service.getAll());
    }
}
