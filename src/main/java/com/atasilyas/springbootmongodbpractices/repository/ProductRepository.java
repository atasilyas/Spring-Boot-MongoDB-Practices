package com.atasilyas.springbootmongodbpractices.repository;

import com.atasilyas.springbootmongodbpractices.model.Product;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository
{
    public List<Product> findAll();

    public Product find(ObjectId id);

    public void create(Product product);

    public void delete(Product product);

    public void update(Product product);

}
