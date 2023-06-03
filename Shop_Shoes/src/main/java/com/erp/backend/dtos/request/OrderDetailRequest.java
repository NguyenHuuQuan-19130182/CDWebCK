package com.erp.backend.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailRequest {
    private Long order;
    private Long size;
    private int quantity;
    private double price;
    private double total;
    private String note;
}
