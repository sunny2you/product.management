package com.demo.product.management.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.convert.DataSizeUnit;

import java.util.Objects;


public class Product {
    private Long id;

    @Size(min=1,max=100)
    private String name;

    @Max(1_000_000)
    @Min(0)
    private Integer price;

    @Max(9_999)
    @Min(0)
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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

}
