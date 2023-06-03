package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.PaymentDto;
import com.erp.backend.entities.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PaymentDtoMapper implements Function<PaymentMethod, PaymentDto> {
    @Override
    public PaymentDto apply(PaymentMethod p) {
        return new PaymentDto(p.getId(), p.getName(), p.getDescription());
    }
}
