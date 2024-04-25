package com.dio.santanderopenacademy.accountbank;

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

            switch (option) {
                case 1:
//                    System.out.println("Enter your credentials: ");
                    createAccount();
                    break;
                case 2:
                    System.out.println("Create an account: ");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }catch (Exception e) {
            System.out.println("An error occurred, pleas try again!");
        }
    }

    public void createAccount() {
        System.out.println("Please enter your credentials:");
        System.out.println("**** CPF: ****");
        String cpfAccount = this.scanner.next();

        System.out.println("**** Name: ****");
        String nameAccount = this.scanner.next();
        nameAccount += " " + this.scanner.nextLine();

        System.out.println("**** Password: ****");
        String passwordAccount = this.scanner.nextLine();

        System.out.println("Your account has been created! Please, do not lose it!");
        System.out.println("*** Create Account Successful! ***\n" + "Name: " + nameAccount + "\n" + "CPF: " + cpfAccount);

        login();
    }

    public void login() {
        boolean authenticated = false;
        System.out.println("**** Enter your credentials: ****");
        System.out.println("**** CPF: ****");
        String cpfAccount = this.scanner.next();
        System.out.println("**** Password: ****");
        String passwordAccount = this.scanner.next();
        authenticated = true;
        if (authenticated) {
            System.out.println("**** Login Successful! ****");
            menuOperation();

        } else {
            System.out.println("**** Login Failed! ****");
        }
    }

    public void menuOperation() {

        System.out.println("**** What would you like to do? ****");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Exit");

        int option = this.scanner.nextInt();
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
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static void main(String[] args) {
        AccountBank accountBank = new AccountBank();
        accountBank.startMenu();
    }
}
