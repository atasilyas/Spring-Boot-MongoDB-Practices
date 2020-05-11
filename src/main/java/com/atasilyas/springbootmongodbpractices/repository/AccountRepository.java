package com.atasilyas.springbootmongodbpractices.repository;

import com.atasilyas.springbootmongodbpractices.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

    void getAccountByStatusAndAndFullnameLike(boolean Status, String regex);

}
