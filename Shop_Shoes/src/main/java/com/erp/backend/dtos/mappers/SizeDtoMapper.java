package com.erp.backend.dtos.mappers;

import com.erp.backend.dtos.ProductDto;
import com.erp.backend.dtos.SizeDto;
import com.erp.backend.entities.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class SizeDtoMapper implements Function<Size, SizeDto> {
    @Override
    public SizeDto apply(Size size) {

        return new SizeDto(size.getSizeId(),size.getSize_num());
    }
}
