package com.demo.product.management.domain;

public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

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
