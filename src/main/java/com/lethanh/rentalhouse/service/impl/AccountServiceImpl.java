package com.lethanh.rentalhouse.service.impl;

import com.lethanh.rentalhouse.model.AccountModel;
import com.lethanh.rentalhouse.repository.AccountRepository;
import com.lethanh.rentalhouse.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountModel save(AccountModel accountModel){
        return accountRepository.save(accountModel);
    }

    @Override
    public List<AccountModel> findAll() {
        return accountRepository.findAll();
    }
}
