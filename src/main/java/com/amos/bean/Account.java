package com.amos.bean;
import org.springframework.hateoas.ResourceSupport;

public class Account extends ResourceSupport{
    private int accountId;
    private String name;
    private String password;

    public Account(){}

    private Account(int accountId, String name, String password) {
        this.accountId = accountId;
        this.name = name;
        this.password = password;
    }

    public static class Builder{
        private int id;
        private String name;
        private String password;

        public Builder(String name){
            this.name = name;
        }
        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Account build(){
            return new Account(id,name,password);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
