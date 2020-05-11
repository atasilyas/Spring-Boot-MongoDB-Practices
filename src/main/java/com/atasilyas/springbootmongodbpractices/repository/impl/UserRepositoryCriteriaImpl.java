package com.atasilyas.springbootmongodbpractices.repository.impl;

import com.atasilyas.springbootmongodbpractices.model.Account;
import com.atasilyas.springbootmongodbpractices.model.Product;
import com.atasilyas.springbootmongodbpractices.model.User;
import com.atasilyas.springbootmongodbpractices.repository.UserRepositoryCriteria;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryCriteriaImpl implements UserRepositoryCriteria {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User find(ObjectId id) {
        return mongoTemplate.findById(id, User.class);
    }

    @Override
    public void create(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(mongoTemplate.findById(id, User.class));
    }

    @Override
    public void update(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public List<User> findByNameContains(String regex) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(
                Criteria.where("name").regex(regex));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public List<User> findByAgeAndAccount(int age, Account account) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(
                Criteria.where("userAccount").is(account));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public List<User> findByAgeOrProduct(int age, Product product) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.orOperator(
                Criteria.where("age").in(age),
                Criteria.where("userProducts").in(product));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, User.class);
    }
}
