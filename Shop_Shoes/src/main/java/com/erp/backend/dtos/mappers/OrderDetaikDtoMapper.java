package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.OrderDto;
import com.erp.backend.dtos.OrderDetailDto;
import com.erp.backend.dtos.ProductDto;
import com.erp.backend.dtos.SizeDto;
import com.erp.backend.entities.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderDetaikDtoMapper implements Function<OrderDetail, OrderDetailDto> {
    @Autowired
    private OrderDtoMapper orderDtoMapper;
    @Autowired
    private ProductDtoMapper productDtoMapper;
    @Override
    public OrderDetailDto apply(OrderDetail orderDetail) {
        OrderDto order = orderDtoMapper.apply(orderDetail.getOrder());
       ProductDto product = productDtoMapper.apply(orderDetail.getProduct());
        return new OrderDetailDto(orderDetail.getId(),order,product,orderDetail.getQuantity(),orderDetail.getSize(),orderDetail.getTotal(),orderDetail.getNote());
    }
}
