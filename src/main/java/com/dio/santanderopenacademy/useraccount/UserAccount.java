package com.dio.santanderopenacademy.useraccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class UserAccount {

    public static void createFile(String username, String cpf, String password, int balance) {

        String pathDir = "src/main/accounts";
        File directory = new File(pathDir);

        String userAccountExists = pathDir + File.separator + cpf + ".json";

        if(new File(userAccountExists).exists()) {
            System.out.println("User already exists, please, enter another!");
            return;
        }


        User user = new User( username, cpf, password);
        user.setBalance(balance);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);


        String fileName = pathDir + File.separator + cpf + ".json";

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
        }catch (Exception e) {
            System.out.println("An error occurred, pleas try again!");
        }

    }

    public static JsonObject readFile(String cpf) {

        String pathDir = "src/main/accounts";
        File directory = new File(pathDir + File.separator + cpf + ".json");

        JsonObject userAccount;
        try (BufferedReader fileBuffer = new BufferedReader(new FileReader(directory))) {
            // read content file JSON
            StringBuilder contentFile = new StringBuilder();
            String jsonFile;

            while((jsonFile = fileBuffer.readLine()) != null) {
                contentFile.append(jsonFile);
            }

            Gson gson = new Gson();
            userAccount = gson.fromJson(contentFile.toString(), JsonObject.class);
            // System.out.println( userAccount);

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return userAccount;
    }

//    public static void main(String[] args) {
//
//        // Lendo e imprimindo os dados do arquivo
//        JsonObject jsonObject = readFile("0321321321");
//        if (jsonObject != null) {
//            System.out.println("User account data:");
//
//        } else {
//            System.out.println("Error reading user account data.");
//        }
//    }

//    public static void main(String[] args) {
//        createFile("wictor hiagoTest", "0321321321", "321",0);
//    }
}
