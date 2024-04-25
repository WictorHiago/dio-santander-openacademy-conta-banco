package com.dio.santanderopenacademy.useraccount;

public class User {
    private String fullname;
    private String numberAccount;
    private String numberAgence;
    private int balance;
    public User ( String fullname, String numberAccount, String numberAgence) {
        this.fullname = fullname;
        this.numberAccount = numberAccount;
        this.numberAgence = numberAgence;
        this.balance = 0;
    }

    public String getFullname() {
        return fullname;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public String getNumberAgence() {
        return numberAgence;
    }

    public int getBalance() {
        return balance;
    }


}
