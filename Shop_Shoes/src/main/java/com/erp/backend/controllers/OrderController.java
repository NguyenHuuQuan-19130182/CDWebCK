package com.erp.backend.controllers;

import com.erp.backend.dtos.auth.OrderDTO;
import com.erp.backend.entities.Order;
import com.erp.backend.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order/create")
    public Order createOrder(@RequestBody @Valid OrderDTO dto){
        return orderService.createOrder(dto);
    }

}
