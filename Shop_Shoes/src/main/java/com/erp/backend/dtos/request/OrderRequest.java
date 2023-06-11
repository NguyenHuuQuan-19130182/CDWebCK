package com.erp.backend.dtos.request;

import com.erp.backend.entities.ShippingInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long idPayment;
    private String note;
    private String state;
    private String email;
    private String name;
    private String phone;
    private String address;
    private String xa;
    private String huyen;
    private String tinh;
    private double totalOrder;
}
