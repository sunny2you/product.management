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

    public Product update(Product product){
        //바꿀 product의 index
        Integer indexToModify = products.indexOf(product); //indexOf는 equals를 기반으로 동일성 판단. 같은 객체가 아니더라도 id값만 같으면 같다고봄.
        products.set(indexToModify, product);
        return product;
    }

    public void delete(Long id){
        Product product = findById(id);
        products.remove(product);
    }

}
