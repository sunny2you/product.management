package com.demo.product.management.infrastructure;

import com.demo.product.management.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ListProductRepository {

    private List <Product> products = new CopyOnWriteArrayList<>();
    private AtomicLong sequence = new AtomicLong(1L);

    public Product add(Product product) {
        product.setId(sequence.getAndAdd(1L));
        System.out.println("Name: " + product.getId());
        products.add(product);
        return product;
    }

    public Product findById(Long id){
        return products.stream()
                .filter(product->product.sameId(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Product> findByNameContaining(String name){
        return products.stream()
                .filter(product->product.containsName(name))
                .toList();
    }

    public List<Product> findAll(){
        return products;
    }


}
