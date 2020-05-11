package com.atasilyas.springbootmongodbpractices.service;

import com.atasilyas.springbootmongodbpractices.model.Product;
import com.atasilyas.springbootmongodbpractices.model.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserServiceCriteria {

    List<User> findAll();

    User find(ObjectId id);

    void create(User user);

    void delete(String id);

    void update(User user);

    List<User> findByNameContains(String regex);

    List<User> findByAgeAndAccount(int age, String acoountId);

    List<User> findByAgeOrProduct(int age, Product product);
}
