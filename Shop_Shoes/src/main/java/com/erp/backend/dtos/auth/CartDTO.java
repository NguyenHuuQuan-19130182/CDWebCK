package com.erp.backend.dtos.auth;

import com.erp.backend.entities.Size;
import com.erp.backend.entities.User;
import lombok.Data;

@Data
public class CartDTO {
    private Long size;
    private Long user;
    private int quantity;
}
