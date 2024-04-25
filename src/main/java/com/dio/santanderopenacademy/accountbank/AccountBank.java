package com.dio.santanderopenacademy.accountbank;

import com.dio.santanderopenacademy.auth.Auth;

import java.util.Scanner;

public class AccountBank {
    private Scanner scanner;

    public AccountBank() {
        this.scanner = new Scanner(System.in);
    }


    public void startMenu () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello there! Welcome to our Bank. What would you like to do?");
        System.out.println("1. Enter your credentials");
        System.out.println("2. Create an account");
        System.out.println("3. Exit");

        try {
            int option = scanner.nextInt();
             Auth auth = new Auth();

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

//    public void menuOperation() {
//
//        System.out.println("**** What would you like to do? ****");
//        System.out.println("1. Deposit");
//        System.out.println("2. Withdraw");
//        System.out.println("3. Transfer");
//        System.out.println("4. Exit");
//
//        int option = this.scanner.nextInt();
//        switch (option) {
//            case 1:
//                System.out.println("Deposit");
//                break;
//            case 2:
//                System.out.println("Withdraw");
//                break;
//            case 3:
//                System.out.println("Transfer");
//                break;
//            case 4:
//                System.out.println("Goodbye!");
//                break;
//            default:
//                System.out.println("Invalid option");
//                break;
//        }
//    }

    public static void main(String[] args) {
        AccountBank accountBank = new AccountBank();
        accountBank.startMenu();
    }
}
