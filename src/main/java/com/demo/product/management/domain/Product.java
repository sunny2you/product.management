package com.demo.product.management.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public void setId(Long id){
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
