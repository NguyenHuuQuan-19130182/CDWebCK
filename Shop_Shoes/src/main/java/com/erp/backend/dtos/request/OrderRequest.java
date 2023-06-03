package com.erp.backend.dtos.request;

import com.erp.backend.entities.PaymentMethod;
import com.erp.backend.entities.ShippingInfo;
import com.erp.backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private ShippingInfo idShip;
    private PaymentMethod idPayment;
    private User idUser;
    private String note;
}
