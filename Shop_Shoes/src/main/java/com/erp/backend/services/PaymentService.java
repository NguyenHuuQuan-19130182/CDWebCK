package com.erp.backend.services;

import com.erp.backend.dtos.PaymentDto;
import com.erp.backend.dtos.mappers.PaymentDtoMapper;
import com.erp.backend.dtos.request.PaymentRequest;
import com.erp.backend.entities.PaymentMethod;
import com.erp.backend.exceptions.ExitException;
import com.erp.backend.models.Response;
import com.erp.backend.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentDtoMapper paymentDtoMapper;

    public PaymentDto createPayment(@Valid PaymentRequest request){
        Optional<PaymentMethod> optionalPayment = paymentRepository.findByName(request.getName());
        if (optionalPayment.isPresent()){
            throw new ExitException(HttpStatus.BAD_REQUEST,"Payment is exits");
        }
        PaymentMethod paymentMethod = PaymentMethod.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        PaymentMethod save = paymentRepository.save(paymentMethod);
        return  paymentDtoMapper.apply(save);
    }

    public Response deletePayment(Long payment_id){
        Optional<PaymentMethod> optionalPaymentMethod = paymentRepository.findById(payment_id);
        PaymentMethod paymentMethod = optionalPaymentMethod.get();
        paymentRepository.delete(paymentMethod);
        return new Response(200,null,null);
    }
}
