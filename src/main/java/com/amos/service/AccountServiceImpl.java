package com.amos.service;

import com.amos.bean.Account;
import com.amos.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public Account getAccountByID(int id) {
        return this.accountMapper.selectAccountByID(id);
    }

    @Override
    public int createAccount(String name) {
        Account insertObj = new Account.Builder(name).build();
        accountMapper.insertAccount(insertObj);
        return insertObj.getId();
    }

    @Override
    public int deleteAccount(int id) {
        return accountMapper.deleteAccountByID(id);
    }

    @Override
    public Account[] selectAll() {
        return accountMapper.selectAll();
    }
}
