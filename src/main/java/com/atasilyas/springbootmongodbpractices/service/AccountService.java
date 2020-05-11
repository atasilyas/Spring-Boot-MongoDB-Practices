package com.atasilyas.springbootmongodbpractices.service;


import com.atasilyas.springbootmongodbpractices.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> findAll();

    Optional<Account> find(String id);

    Account save(Account account);

    void delete(Account account);

    void getAccountByStatusAndAndFullNameLike(boolean status, String regex);


}
