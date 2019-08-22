package com.amos.controller;

import com.amos.bean.Account;
import com.amos.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/")
    public String welcome() {
        return "Welcome!";
    }

    @RequestMapping("/get")
    public Account getAccount(@RequestParam(value = "id", defaultValue = "1") int id) {
        return accountService.getAccountByID(id);
    }

    @RequestMapping("/add")
    public int addAccount(@RequestParam(value = "name") String name) {
        return accountService.createAccount(name);
    }

    @RequestMapping("/all")
    public Account[] selectAll() {
        return accountService.selectAll();
    }
}
