package com.demo.product.management.application;

import com.demo.product.management.domain.Product;
import com.demo.product.management.infrastructure.ListProductRepository;
import com.demo.product.management.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {

    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;
    private ValidationService validationService;

    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper, ValidationService validationService) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
        this.validationService =validationService;
    }

    public ProductDto add(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        validationService.checkValid(product);
        Product savedProduct = listProductRepository.add(product);
        ProductDto savedProductDto = modelMapper.map(savedProduct,ProductDto.class);
        return savedProductDto;
    }

    public ProductDto findById(Long id){
        Product product= listProductRepository.findById(id);
        ProductDto productDto= modelMapper.map(product,ProductDto.class);
        return productDto;

    }


    public List<ProductDto> findByName(String name){
        List<Product> products=listProductRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream().map(product->modelMapper.map(product,ProductDto.class))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findAll(){
        List<Product> products=listProductRepository.findAll();
        List<ProductDto> productDtos = products.stream().map(product->modelMapper.map(product,ProductDto.class))
                .toList();
        return productDtos;
    }

    public ProductDto update(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        Product updatedproduct = listProductRepository.update(product);
        ProductDto savedProductDto = modelMapper.map(updatedproduct,ProductDto.class);
        System.out.println(savedProductDto);
        return savedProductDto;
    }

    public void delete(Long id){
        listProductRepository.delete(id);
    }

}
