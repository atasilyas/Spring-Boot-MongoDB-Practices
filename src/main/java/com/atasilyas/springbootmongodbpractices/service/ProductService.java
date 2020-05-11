package com.atasilyas.springbootmongodbpractices.service;


import com.atasilyas.springbootmongodbpractices.model.Product;
import org.bson.types.ObjectId;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product find(ObjectId id);

    void create(Product product);

    void delete(Product product);

    void update(Product product);

}
