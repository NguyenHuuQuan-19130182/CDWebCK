package com.erp.backend.services;

import com.erp.backend.dtos.SizeDto;
import com.erp.backend.dtos.auth.SizeDTO;
import com.erp.backend.dtos.mappers.SizeDtoMapper;
import com.erp.backend.dtos.request.SizeRequest;
import com.erp.backend.entities.Product;
import com.erp.backend.entities.Size;
import com.erp.backend.repositories.ProductRepository;
import com.erp.backend.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private SizeDtoMapper mapper;
    @Autowired
    private ProductRepository productRepository;

    public List<SizeDto> getAll(){
        List<Size> list = sizeRepository.findAll();
        List<SizeDto> sizeDtoList = list.stream().map(mapper::apply).collect(Collectors.toList());
        return sizeDtoList;
    }

    public Size createSize(SizeDTO sizeDTO){
        Size size = new Size();
        size.setSize_num(sizeDTO.getNSize());

        return sizeRepository.save(size);
    }
    public  SizeDto create(@Valid SizeRequest request){
        Size size = Size.builder()
                .size_num(request.getNSize())
                .build();
        Size save = sizeRepository.save(size);
        return mapper.apply(save);
    }
}
