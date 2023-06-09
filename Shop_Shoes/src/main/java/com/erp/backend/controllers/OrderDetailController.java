package com.erp.backend.controllers;

import com.erp.backend.dtos.OrderDetailDto;
import com.erp.backend.dtos.request.OrderDetailRequest;
import com.erp.backend.services.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class OrderDetailController {
    @Autowired
    private OrderDetailService service;

    @PostMapping("/checkout/{orderId}")
    public ResponseEntity<?> create(@RequestBody OrderDetailRequest request,@PathVariable(value = "orderId") Long orderId){
        return ResponseEntity.ok(service.create(request,orderId));
    }
    @GetMapping("/checkout/{userId}")
    public ResponseEntity<?> getAllOrderByUser(@PathVariable(value = "userId") Long userId){
        return ResponseEntity.ok(service.getLstOrderByUser(userId));
    }
    @GetMapping("/checkout/order/{orderId}")
    public ResponseEntity<?> getAllOrderByOrder(@PathVariable(value = "orderId") Long orderId){
        return ResponseEntity.ok(service.getOrderDetailByOrder(orderId));
    }
    @DeleteMapping("/order-detail/delete/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.deleteOrderDetail(id));
    }
}
