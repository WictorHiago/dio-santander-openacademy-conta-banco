package com.dio.santanderopenacademy.auth;
import com.dio.santanderopenacademy.useraccount.UserAccount;
import java.util.Scanner;
public class Auth {

    private Scanner scanner;

    public Auth() {
        this.scanner = new Scanner(System.in);
    }

    public void login() {
        System.out.println("**** Enter your credentials: ****");
        System.out.println("**** CPF: ****");
        String cpfAccount = this.scanner.next();
        System.out.println("**** Password: ****");
        String passwordAccount = this.scanner.next();

        String userAccountExists = "src/main/accounts/" + cpfAccount + ".json";
        // verify if user file exists
        if(UserAccount.readFile(cpfAccount) == true) {
            System.out.println("Login Successful!");
        }else {
            System.out.println("Invalid credentials, please try again!");
        }

    }

    public void register() {
        System.out.println("Please enter your credentials:");
        System.out.println("**** CPF: ****");
        String cpfAccount = this.scanner.next();

        System.out.println("**** Name: ****");
        String nameAccount = this.scanner.next();
        nameAccount += " " + this.scanner.nextLine();

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
