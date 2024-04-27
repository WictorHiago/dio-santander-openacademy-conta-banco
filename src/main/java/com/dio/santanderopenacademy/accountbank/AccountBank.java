package com.dio.santanderopenacademy.accountbank;

import com.dio.santanderopenacademy.auth.Auth;

import java.util.Scanner;

public class AccountBank {
    private Scanner scanner;

    public AccountBank() {
        this.scanner = new Scanner(System.in);
    }


    public void startMenu () {

        System.out.println("Hello there! Welcome to our Bank. What would you like to do?");
        System.out.println("1. Enter your credentials");
        System.out.println("2. Create an account");
        System.out.println("3. Exit");

        int option = this.scanner.nextInt();
        Auth auth = new Auth();

        try {

            switch (option) {
                case 1:
                    auth.login();
                    break;
                case 2:
                    auth.register();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
                    startMenu();
                    break;
            }

        }catch (Exception e) {
            System.out.println("An error occurred, pleas try again!");
        }
    }

    public static void main(String[] args) {
        AccountBank accountBank = new AccountBank();
        accountBank.startMenu();
    }
}
