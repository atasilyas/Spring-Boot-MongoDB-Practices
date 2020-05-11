package com.atasilyas.springbootmongodbpractices.repository;

import com.atasilyas.springbootmongodbpractices.model.Product;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product find(ObjectId id);

    void create(Product product);

    void delete(Product product);

    void update(Product product);

}
