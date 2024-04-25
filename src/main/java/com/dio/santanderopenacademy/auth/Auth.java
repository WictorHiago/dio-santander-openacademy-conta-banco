package com.dio.santanderopenacademy.auth;
import com.dio.santanderopenacademy.Operation;
import com.dio.santanderopenacademy.useraccount.UserAccount;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.Scanner;
public class Auth {

    private Scanner scanner;
    private String accountLogged;

    private Operation operation;

    public Auth() {
        this.scanner = new Scanner(System.in);
        this.operation = new Operation();
    }

    public void login() {
        System.out.println("**** Enter your credentials: ****");
        System.out.println("**** CPF: ****");
        String cpfAccount = this.scanner.next();
        System.out.println("**** Password: ****");
        String passwordAccount = this.scanner.next();

        String userAccountExists = "src/main/accounts/" + cpfAccount + ".json";

        if(new File(userAccountExists).exists()) {
            JsonObject userAccount = UserAccount.readFile(cpfAccount);

            if(userAccount.get("password").getAsString().equals(passwordAccount)) {

                this.accountLogged = userAccount.get("username").getAsString();

                this.operation.menuOperation(this.accountLogged);
                System.out.println("welcome " + this.accountLogged);

            }else {
                System.out.println("Not authorized, please, try again!");
                this.operation.menuOperation("");
            }
        }else {
            System.out.println("Account not found, please try again!");
        }

    }

    public void register() {
        System.out.println("Please enter your credentials:");
        System.out.println("**** CPF: ****");
        String cpfAccount = this.scanner.next();

        System.out.println("**** Name: ****");
        String nameAccount = this.scanner.next();
        nameAccount += " " + this.scanner.nextLine();
        nameAccount = nameAccount.toUpperCase();

        System.out.println("**** Password: ****");
        String passwordAccount = this.scanner.nextLine();

        UserAccount.createFile(nameAccount, cpfAccount, passwordAccount, 0);
    }


//    public static void main(String[] args ) {
//        Auth auth = new Auth();
////        auth.login();
//        auth.register();
//
//    }
}
