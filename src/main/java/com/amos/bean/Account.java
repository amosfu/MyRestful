package com.amos.bean;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Account extends ResourceSupport{
    private int accountId;
    private String name;

    public Account(){};

    private Account(int acountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }

    public static class Builder{
        private int id;
        private String name;

        public Builder(String name){
            this.name = name;
        }
        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Account build(){
            return new Account(id,name);
        }
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
