package com.erp.backend.services;


import com.erp.backend.dtos.ProductDto;
import com.erp.backend.dtos.auth.ProductDTO;
import com.erp.backend.dtos.auth.SearchDto;
import com.erp.backend.dtos.mappers.ProductDtoMapper;
import com.erp.backend.entities.Category;
import com.erp.backend.entities.Product;
import com.erp.backend.repositories.CategoryRepository;
import com.erp.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDtoMapper mapper;
    @Autowired
    private CategoryRepository categoryRepository;

    public Product createProduct(ProductDTO dto){
        Product product = new Product();
        Category category = categoryRepository.findById(dto.getIdCategory()).get();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setSellPrice(dto.getSellPrice());
        product.setImg(dto.getImg());
        product.setQuantity(dto.getQuantity());
        product.setCategory(category);
        return productRepository.save(product);
    }

    public List<ProductDto> getAllProduct(){
        List<Product> list = productRepository.findAll();
        List<ProductDto> productDtoList = list.stream().map(mapper::apply).collect(Collectors.toList());
        return productDtoList;
    }
    public ProductDto getAllProductID(long id){
        return  mapper.apply(productRepository.findById(id).get());
    }
    public List<ProductDto> getListByCategory(long id_category){
        List<Product> list = productRepository.getListByCategory(id_category);
        List<ProductDto> productDtos = list.stream().map(mapper::apply).collect(Collectors.toList());
        return productDtos;
    }
    public List<ProductDto> getLstProductParentId(long parent_id){
        List<Product> list = productRepository.getLstProductParentId(parent_id);
        List<ProductDto> productDtos = list.stream().map(mapper::apply).collect(Collectors.toList());
        return productDtos;
    }

    public List<ProductDto> getInfoPro(long id){
        List<Product> list = productRepository.getProductBySize(id);
        List<ProductDto> productDtos = list.stream().map(mapper::apply).collect(Collectors.toList());
        return  productDtos;
    }

    public long getTotalProduct(long id){
        return productRepository.countProductByID(id);
    }
    public long getTotalProductByCategory(long id){
        return  productRepository.countProductByIdCaregory(id);
    }
    public List<Product> sortProducts(String sortType) {
        if (sortType.equals("name_asc")) {
            return  productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        } else if (sortType.equals("name_desc")) {
            return  productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        } else if (sortType.equals("price_asc")) {
            return  productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
        } else if (sortType.equals("price_desc")) {
            return  productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        } else {
            return  productRepository.findAll();
        }
    }

    public List<ProductDto> search(SearchDto keyword){
        return  productRepository.search(keyword.getKeyword()).stream().map(mapper::apply).collect(Collectors.toList());
    }

    public Page<ProductDto> getAllProductPage(int page,int size){
        Page<Product> products = productRepository.findAll(PageRequest.of(page,size));
        Page<ProductDto> productDtos = products.map(mapper);
        return productDtos;
    }

}