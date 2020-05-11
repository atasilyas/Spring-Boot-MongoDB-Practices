package com.atasilyas.springbootmongodbpractices.service.impl;

import com.atasilyas.springbootmongodbpractices.model.Account;
import com.atasilyas.springbootmongodbpractices.repository.AccountRepository;
import com.atasilyas.springbootmongodbpractices.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> find(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.insert(account);
    }


    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public void getAccountByStatusAndAndFullNameLike(boolean status, String regex) {
        accountRepository.getAccountByStatusAndAndFullnameLike(status, regex);
    }
}
