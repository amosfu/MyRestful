package com.amos.bean;

public class Account {
    private int id;
    private String name;

    private Account(int id, String name) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
