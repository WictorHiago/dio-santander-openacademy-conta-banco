package com.dio.santanderopenacademy.operation;
import com.dio.santanderopenacademy.auth.Auth;
import com.dio.santanderopenacademy.useraccount.UserAccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Operation {

    private Scanner scanner;

    public Operation() {
        this.scanner = new Scanner(System.in);
    }

    public void menuOperation(String accountLogged, String fileAccount) {
        String userAccount = accountLogged;

        Scanner scanner = new Scanner(System.in);
        System.out.println("**** Welcome " + userAccount + " ****");
        System.out.println("**** What would you like to do? ****");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Exit");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Deposit");
                JsonObject user = UserAccount.readFile(fileAccount);

                System.out.println("**** How much would you like to deposit? ****");
                double amountDeposit = this.scanner.nextDouble();

                System.out.println("**** Confirm: [1] Deposit [2] Cancel ****");
                int confirmDeposit = this.scanner.nextInt();

                if(confirmDeposit == 1) {
                    user.addProperty("balance", user.get("balance").getAsInt() + amountDeposit);

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();

                    String json = gson.toJson(user);
                    System.out.println(json);

                    try {
                        FileWriter fileWriter = new FileWriter("src/main/accounts/" + fileAccount + ".json" );
                        fileWriter.write(json);
                        fileWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }

                break;
            case 2:
                System.out.println("Withdraw");
                user = UserAccount.readFile(fileAccount);

                System.out.println("**** How much would you like to withdraw? ****");
                double amountWithdraw = this.scanner.nextDouble();

                System.out.println("**** Confirm: [1] Withdraw [2] Cancel ****");
                int confirmWithdraw = this.scanner.nextInt();

                if(confirmWithdraw == 1) {
                    user.addProperty("balance", user.get("balance").getAsInt() - amountWithdraw);

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();

                    String json = gson.toJson(user);
                    System.out.println(json);

                    try {
                        FileWriter fileWriter = new FileWriter("src/main/accounts/" + fileAccount + ".json" );
                        fileWriter.write(json);
                        fileWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                break;
            case 3:
                System.out.println("Thanks for using our services!");
                System.out.println("Exit");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
        }
    }



}
