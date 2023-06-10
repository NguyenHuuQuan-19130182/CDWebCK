package com.erp.backend.services;


import com.erp.backend.dtos.ProductDto;
import com.erp.backend.dtos.SortProductDto;
import com.erp.backend.dtos.auth.ProductDTO;
import com.erp.backend.dtos.auth.SearchDto;
import com.erp.backend.dtos.mappers.ProductDtoMapper;
import com.erp.backend.entities.Category;
import com.erp.backend.entities.Product;
import com.erp.backend.repositories.CategoryRepository;
import com.erp.backend.repositories.ProductRepository;
import com.erp.backend.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDtoMapper mapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SizeRepository sizeRepository;

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

    public ProductDto getInfoPro(long id){
       Product dto = productRepository.findProductById(id);
       return mapper.apply(dto);
    }

    public long getTotalProduct(long id){
        return productRepository.countProductByID(id);
    }
    public long getTotalProductByCategory(long id){
        return  productRepository.countProductByIdCaregory(id);
    }

    public List<Product> sortProducts(SortProductDto sortType) {
//        List<Product> product = productRepository.findAll();
//        if(sortType.equals("name_asc")){
//              Collections.sort(product, Comparator.comparing(Product::getName));
//        }else if(sortType.equals("name_desc")){
//            Collections.sort(product, Comparator.comparing(Product::getName).reversed());
//        }else if (sortType.equals("price_asc")) {
//            Collections.sort(product, Comparator.comparing(Product::getPrice));
//        }else if (sortType.equals("price_desc")) {
//            Collections.sort(product, Comparator.comparing(Product::getPrice).reversed());
//        }
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
//        return product;
    }
    public List<Product> getProductsByNameAsc() {
        List<Product> products = productRepository.findAll();
        Collections.sort(products, Comparator.comparing(Product::getName));
        return products;
    }
    public List<Product> getProductsByNameDesc() {
        List<Product> products = productRepository.findAll();
        Collections.sort(products, Comparator.comparing(Product::getName).reversed());
        return products;
    }
    public List<Product> getProductsByPriceAsc() {
        List<Product> products = productRepository.findAll();
        Collections.sort(products, Comparator.comparing(Product::getPrice));
        return products;
    }
    public List<Product> getProductsByPriceDesc() {
        List<Product> products = productRepository.findAll();
        Collections.sort(products, Comparator.comparing(Product::getPrice).reversed());
        return products;
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
