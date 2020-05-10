package com.atasilyas.springbootmongodbpractices.service.impl;

import com.atasilyas.springbootmongodbpractices.model.Product;
import com.atasilyas.springbootmongodbpractices.repository.ProductRepository;
import com.atasilyas.springbootmongodbpractices.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product find(ObjectId id) {
        return productRepository.find(id);
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }
}
