package com.dio.santanderopenacademy;
import com.dio.santanderopenacademy.auth.Auth;

import java.util.Scanner;
public class Operation {

    private Scanner scanner;

    public Operation() {
        this.scanner = new Scanner(System.in);
    }

    public void menuOperation(String accountLogged) {
        Scanner scanner = new Scanner(System.in);
        String userAccount = accountLogged;
        System.out.println("**** Welcome " + userAccount + " ****");
        System.out.println("**** What would you like to do? ****");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Exit");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Deposit");
                break;
            case 2:
                System.out.println("Withdraw");
                break;
            case 3:
                System.out.println("Transfer");
                break;
            case 4:
                System.out.println("Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option");
                menuOperation("");
        }
    }



}
