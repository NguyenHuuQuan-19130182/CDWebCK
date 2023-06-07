package com.erp.backend.services;

import com.erp.backend.dtos.OrderDetailDto;
import com.erp.backend.dtos.auth.OrderDetailDTO;
import com.erp.backend.dtos.mappers.OrderDetaikDtoMapper;
import com.erp.backend.dtos.mappers.OrderDtoMapper;
import com.erp.backend.dtos.request.OrderDetailRequest;
import com.erp.backend.entities.Order;
import com.erp.backend.entities.OrderDetail;
import com.erp.backend.entities.Product;
import com.erp.backend.repositories.OrderDetailRepository;
import com.erp.backend.repositories.OrderRepository;
import com.erp.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderDetaikDtoMapper mapper;
    @Autowired
    private ProductRepository productRepository;

    public OrderDetail create(OrderDetailRequest request,Long idOrder){
        Order order = orderRepository.findById(idOrder).get();
        Product product = productRepository.findById(request.getProduct()).get();

        OrderDetail orderDetail = OrderDetail.builder()
                .order(order)
                .product(product)
                .quantity(request.getQuantity())
                .size(request.getSize())
                .total(request.getTotal())
                .note(request.getNote())
                .build();
        return orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetailDto> getLstOrderByUser(long idUser){
        List<OrderDetail> list = orderDetailRepository.getOrderDetailByUser(idUser);
        List<OrderDetailDto>  detailDtos = list.stream().map(mapper::apply).collect(Collectors.toList());
        return detailDtos;
    }

}