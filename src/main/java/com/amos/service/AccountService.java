package com.amos.service;

import com.amos.bean.Account;
import org.springframework.stereotype.Component;

@Component
public interface AccountService {
    Account getAccountByID(int accountId);

    int createAccount(Account account);

    int createUpdateAccount(Account account);

    int deleteAccount(int accountId);

    Account[] selectAll();
}
