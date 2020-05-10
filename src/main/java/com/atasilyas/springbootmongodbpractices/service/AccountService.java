package com.atasilyas.springbootmongodbpractices.service;


import com.atasilyas.springbootmongodbpractices.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public List<Account> findAll();

    public Optional<Account> find(String id);

    public Account  save(Account account);

    public void delete(Account account);

    public void getAccountByStatusAndAndFullNameLike(boolean status, String regex);


    }
