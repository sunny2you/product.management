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

    //찾고 있는 id와 같은지 확인하는 함수
    public Boolean sameId(Long id){
        return this.id.equals(id);
    }

    //찾고 있는 name이 포함하고 있는지 확인하는 함수
    public Boolean containsName(String name){
        return this.name.contains(name);
    }
}
