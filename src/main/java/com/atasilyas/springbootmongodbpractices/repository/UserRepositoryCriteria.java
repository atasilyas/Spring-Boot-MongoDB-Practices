package com.atasilyas.springbootmongodbpractices.repository;

import com.atasilyas.springbootmongodbpractices.model.Account;
import com.atasilyas.springbootmongodbpractices.model.Product;
import com.atasilyas.springbootmongodbpractices.model.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserRepositoryCriteria {

    List<User> findAll();

    User find(ObjectId id);

    void create(User user);

    void delete(String id);

    void update(User user);

    List<User> findByNameContains(String regex);

    List<User> findByAgeAndAccount(int age, Account account);

    List<User> findByAgeOrProduct(int age, Product product);


}
