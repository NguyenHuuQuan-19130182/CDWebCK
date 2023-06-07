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
    private Long product;
    private int quantity;
    private double total;
    private String note;
    private int size;
}
