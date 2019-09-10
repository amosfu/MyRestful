package com.amos.controller;

import com.amos.bean.Account;
import com.amos.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/account")
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    public Account[] getAccountAll(HttpServletRequest request) {
        // can do sth with HttpRequests
        return accountService.selectAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{accountId}")
    public Account[] getAccount(@PathVariable int accountId) {
        return new Account[]{accountService.getAccountByID(accountId)};
    }

    @RequestMapping(method = RequestMethod.POST)
    public int createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{accountId}" )
    public int createUpdateAccount(@PathVariable int accountId, @RequestBody Account account) {
        account.setAccountId(accountId);
        return accountService.createUpdateAccount(account);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{accountId}")
    public int deleteAccount(@PathVariable int accountId) {
        return accountService.deleteAccount(accountId);
    }
}
