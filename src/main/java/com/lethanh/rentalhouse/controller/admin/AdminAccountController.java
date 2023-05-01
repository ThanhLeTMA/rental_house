package com.lethanh.rentalhouse.controller.admin;

import com.lethanh.rentalhouse.model.AccountModel;
import com.lethanh.rentalhouse.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminAccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("/admin/accounts")
    public AccountModel createAccount(@RequestBody AccountModel accountModel){
        return accountService.save(accountModel);
    }
    @GetMapping("/admin/accounts")
    public List<AccountModel> findAll(){
        return accountService.findAll();
    }
}
