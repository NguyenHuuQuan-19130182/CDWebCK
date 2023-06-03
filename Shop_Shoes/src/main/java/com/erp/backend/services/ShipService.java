package com.erp.backend.services;

import com.erp.backend.dtos.ShipDto;
import com.erp.backend.dtos.mappers.ShipDtoMapper;
import com.erp.backend.dtos.request.ShipRequest;
import com.erp.backend.entities.ShippingInfo;
import com.erp.backend.repositories.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ShipService {
    @Autowired
    private ShippingRepository repository;
    @Autowired
    private ShipDtoMapper mapper;

    public ShipDto createShipping(@Valid ShipRequest request){
        ShippingInfo shippingInfo = ShippingInfo.builder()
                .shippingEmail(request.getEmail())
                .shippingName(request.getName())
                .shippingAddress(request.getAddress())
                .shippingPhone(request.getPhone())
                .xa(request.getXa())
                .huyen(request.getHuyen())
                .tinh(request.getTinh())
                .build();
        ShippingInfo save = repository.save(shippingInfo);
        return  mapper.apply(save);
    }
}


