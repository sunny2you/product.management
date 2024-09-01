package com.demo.product.management.presentation;

import com.demo.product.management.application.SimpleProductService;
import com.demo.product.management.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    @RequestMapping(value="/products", method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        //product 생성 후 리스트에 넣는 작업
        return simpleProductService.add(productDto);
    }

    @RequestMapping(value="/products/{id}",method=RequestMethod.GET)
    public ProductDto findProductById(@PathVariable Long id) {
        return simpleProductService.findById(id);
    }

    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<ProductDto> findProducts(@RequestParam(required=false) String name){
        if(name == null) {
            return simpleProductService.findAll();
        }

        return simpleProductService.findByName(name);
    }

}




