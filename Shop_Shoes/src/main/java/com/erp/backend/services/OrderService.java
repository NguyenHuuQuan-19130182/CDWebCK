package com.erp.backend.services;

import com.erp.backend.dtos.OrderDto;
import com.erp.backend.dtos.mappers.OrderDtoMapper;
import com.erp.backend.dtos.request.OrderRequest;
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

    public Order createOrder(OrderRequest request,String email,Long IdShip) {
        User user = userRepository.findByEmail(email).get();
        ShippingInfo shippingInfo = shippingRepository.findById(IdShip).get();
        PaymentMethod paymentMethod = paymentRepository.findById(request.getIdPayment()).get();
        Order order = Order.builder()
                .account(user)
                .shippingInfo(shippingInfo)
                .paymentMethod(paymentMethod)
                .note(request.getNote())
                .state(request.getState())
                .build();
     return orderRepository.save(order);
    }
    public OrderDto getAllOrderById(long id){
        return orderDtoMapper.apply(orderRepository.findById(id).get());
    }

}
