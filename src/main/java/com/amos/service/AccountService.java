package com.amos.service;

import com.amos.bean.Account;
import org.springframework.stereotype.Component;

@Component
public interface AccountService {
    Account getAccountByID(int id);

    int createAccount(String name);

    int deleteAccount(int id);

    Account[] selectAll();
}
