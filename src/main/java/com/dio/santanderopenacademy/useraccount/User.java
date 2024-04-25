package com.dio.santanderopenacademy.useraccount;

public class User {
    private String username;
    private String cpf;
    private String password;
    private int balance;
    public User ( String username, String cpf, String password) {
        this.username = username;
        this.cpf = cpf;
        this.password = password;
        this.balance = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
