package com.erp.backend.services;

import com.erp.backend.dtos.OrderDto;
import com.erp.backend.dtos.auth.OrderDTO;
import com.erp.backend.dtos.mappers.OrderDtoMapper;
import com.erp.backend.entities.Order;
import com.erp.backend.entities.PaymentMethod;
import com.erp.backend.entities.ShippingInfo;
import com.erp.backend.entities.User;
import com.erp.backend.repositories.OrderRepository;
import com.erp.backend.repositories.PaymentRepository;
import com.erp.backend.repositories.ShippingRepository;
import com.erp.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDtoMapper orderDtoMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ShippingRepository shippingRepository;

    public Order createOrder(OrderDTO dto){
        Order order = new Order();

        User user = userRepository.findById(dto.getUser()).get();
        PaymentMethod payment = paymentRepository.findById(dto.getPayment()).get();
        ShippingInfo ship = shippingRepository.findById(dto.getShipping()).get();

        order.setAccount(user);
        order.setPaymentMethod(payment);
        order.setShippingInfo(ship);
        order.setState(dto.getState());
        order.setNote(dto.getNote());
     return orderRepository.save(order);
    }
    public OrderDto getAllOrderById(long id){
        return orderDtoMapper.apply(orderRepository.findById(id).get());
    }

}
