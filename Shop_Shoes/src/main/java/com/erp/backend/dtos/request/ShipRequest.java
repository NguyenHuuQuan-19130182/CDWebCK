package com.erp.backend.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipRequest {
    private String email;
    private String name;
    private String phone;
    private String address;
    private String xa;
    private String huyen;
    private String tinh;

}
