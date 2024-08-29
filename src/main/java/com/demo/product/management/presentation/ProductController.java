package com.demo.product.management.presentation;

import com.demo.product.management.application.SimpleProductService;
import com.demo.product.management.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    @RequestMapping(value="/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        //product 생성 후 리스트에 넣는 작업
        return product;
    }
}
