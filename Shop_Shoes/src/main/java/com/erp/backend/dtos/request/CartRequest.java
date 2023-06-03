package com.erp.backend.dtos.request;

import com.erp.backend.entities.Size;
import com.erp.backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private Long size;
    private Long user;
    private int quantity;
}
