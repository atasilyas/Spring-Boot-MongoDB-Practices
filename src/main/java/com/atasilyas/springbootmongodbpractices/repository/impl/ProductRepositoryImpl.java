package com.atasilyas.springbootmongodbpractices.repository.impl;

import com.atasilyas.springbootmongodbpractices.model.Product;
import com.atasilyas.springbootmongodbpractices.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> findAll() {
        try {
            return mongoTemplate.findAll(Product.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Product find(ObjectId id) {  // findOne(id, Product.class) should work but it didt wor I couldnt fix it.
        try {
            Criteria criteria = new Criteria();
            criteria.where("_id").is(id);
            Query gQuery =  new Query();
            gQuery.addCriteria(criteria);
            return mongoTemplate.findOne(gQuery, Product.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Product product) {
        try {
            mongoTemplate.insert(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Product product) {
        try {
            mongoTemplate.remove(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        try {
            mongoTemplate.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
