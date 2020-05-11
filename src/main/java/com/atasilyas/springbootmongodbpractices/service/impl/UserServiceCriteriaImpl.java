package com.atasilyas.springbootmongodbpractices.service.impl;

import com.atasilyas.springbootmongodbpractices.advice.BusinessException;
import com.atasilyas.springbootmongodbpractices.model.Account;
import com.atasilyas.springbootmongodbpractices.model.Product;
import com.atasilyas.springbootmongodbpractices.model.User;
import com.atasilyas.springbootmongodbpractices.repository.UserRepositoryCriteria;
import com.atasilyas.springbootmongodbpractices.service.AccountService;
import com.atasilyas.springbootmongodbpractices.service.UserServiceCriteria;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceCriteriaImpl implements UserServiceCriteria {

    Logger LOGGER =  LoggerFactory.getLogger(UserServiceCriteriaImpl.class);

    private final UserRepositoryCriteria userRepositoryCriteria;

    private final AccountService accountService;

    @Override
    public List<User> findAll() {
        return userRepositoryCriteria.findAll();
    }

    @Override
    public User find(ObjectId id) {
        return userRepositoryCriteria.find(id);
    }

    @Override
    public void create(User user) {
        userRepositoryCriteria.create(user);
        throw  new BusinessException("Hata");
    }

    @Override
    public void delete(String id) {
        userRepositoryCriteria.delete(id);
    }

    @Override
    public void update(User user) {
        userRepositoryCriteria.update(user);
    }

    @Override
    public List<User> findByNameContains(String regex) {
        return userRepositoryCriteria.findByNameContains(regex);
    }

    @Override
    public List<User> findByAgeAndAccount(int age, String acoountId) {

        Account account;
        try {
            account = accountService.find(acoountId).orElseThrow(Exception::new);
        } catch (Exception e) {
            throw new RuntimeException("Account is not exist.");
        }
        return userRepositoryCriteria.findByAgeAndAccount(age, account);
    }

    @Override
    public List<User> findByAgeOrProduct(int age, Product product) {
        return userRepositoryCriteria.findByAgeOrProduct(age, product);
    }
}
