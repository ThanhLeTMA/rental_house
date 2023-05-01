package com.lethanh.rentalhouse.service;

import com.lethanh.rentalhouse.model.AccountModel;

import java.util.List;

public interface AccountService {
    AccountModel save(AccountModel accountModel);
    List<AccountModel> findAll();
}
