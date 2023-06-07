package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.ShipDto;
import com.erp.backend.entities.ShippingInfo;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ShipDtoMapper implements Function<ShippingInfo, ShipDto> {

    @Override
    public ShipDto apply(ShippingInfo shippingInfo) {
        return new ShipDto(shippingInfo.getShippingEmail(),shippingInfo.getShippingName()
        ,shippingInfo.getShippingPhone(),shippingInfo.getShippingAddress(),shippingInfo.getXa(),shippingInfo.getHuyen(),shippingInfo.getTinh());
    }
}
