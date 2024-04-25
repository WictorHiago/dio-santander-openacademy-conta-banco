package com.dio.santanderopenacademy.auth;
import com.dio.santanderopenacademy.operation.Operation;
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
        System.out.println("**** Account name: ****");
        String fullname = this.scanner.nextLine().toUpperCase();

        System.out.println("**** Number account: ****");
        String numberAccount = this.scanner.next();

        String filename = fullname.toUpperCase().replace(" ", "-") + "-" + numberAccount;

        String fileAccount = "src/main/accounts/" + filename + ".json"; // fullpath

        if(new File(fileAccount).exists()) {
            JsonObject userAccount = UserAccount.readFile(filename);

            if(!userAccount.get("fullname").getAsString().equals(fullname)) {
                System.out.println("Account not found, please try again!");
            }
            this.accountLogged = fullname;
            operation.menuOperation(this.accountLogged,filename);

        }else {
            System.out.println("Account not found, please try again!");
        }

    }

    public void register() {
        System.out.println("Enter your full name:");
        String fullname = this.scanner.nextLine();
        System.out.println(fullname);

        UserAccount.createFile(fullname, 0);
        System.out.println("User account created successfully!");
    }

}
