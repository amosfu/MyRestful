package com.amos.controller;

import com.amos.bean.Account;
import com.amos.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Account[] getAccount(@RequestParam(value = "id") int id) {
        if (id >= 0)
            return new Account[]{accountService.getAccountByID(id)};
        else
            return accountService.selectAll();
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public int addAccount(@RequestParam(value = "name") String name) {
        return accountService.createAccount(name);
    }

    @RequestMapping(value = "/account", method = RequestMethod.DELETE)
    public int deleteAccount(@RequestParam(value = "id") int id) {
        return accountService.deleteAccount(id);
    }
}
