package com.atasilyas.springbootmongodbpractices.service;


import com.atasilyas.springbootmongodbpractices.model.Product;
import org.bson.types.ObjectId;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product find(ObjectId id);

    public void create(Product product);

    public void delete(Product product);

    public void update(Product product);

}
