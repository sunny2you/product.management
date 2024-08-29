package com.demo.product.management.application;

import com.demo.product.management.domain.Product;
import com.demo.product.management.infrastructure.ListProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {

    private ListProductRepository listProductRepository;

    @Autowired
    SimpleProductService(ListProductRepository listProductRepository) {
        this.listProductRepository = listProductRepository;
    }

    public Product add(Product product){
        Product savedProduct = listProductRepository.add(product);
        return savedProduct;
    }

}
