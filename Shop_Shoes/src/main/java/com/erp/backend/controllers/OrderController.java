package com.erp.backend.controllers;

import com.erp.backend.dtos.auth.OrderDTO;
import com.erp.backend.dtos.request.OrderRequest;
import com.erp.backend.entities.Order;
import com.erp.backend.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/{idShip}/order/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request, @RequestAttribute("email") String email,@PathVariable("idShip") Long idShip){
        return ResponseEntity.ok(orderService.createOrder(request,email,idShip));
    }

}
