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

    public Account getAccountByID(int accountId) {
        return this.accountMapper.selectAccountByID(accountId);
    }

    public int createAccount(Account account) {
        accountMapper.insertAccount(account);
        return account.getAccountId();
    }

    public int createUpdateAccount(Account account) {
        return accountMapper.insertUpdateAccount(account);
    }

    public int deleteAccount(int accountId) {
        return accountMapper.deleteAccountByID(accountId);
    }

    public Account[] selectAll() {
        return accountMapper.selectAll();
    }
}
