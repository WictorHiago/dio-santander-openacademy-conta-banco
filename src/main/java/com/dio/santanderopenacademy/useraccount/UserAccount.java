package com.dio.santanderopenacademy.useraccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;


public class UserAccount {

    public static void createFile(String fullname, int balance) {

        String dirAccounts = "src/main/accounts";

        String userAccount = dirAccounts + File.separator + fullname + ".json";

        if(new File(userAccount).exists()) {
            System.out.println("User already exists, please, enter another!");
            return;
        }

        Random random = new Random();

        String accountNumber = String.format("%04d", random.nextInt(9999) +1);
        String agenceNumber = String.format("%04d", random.nextInt(9999) +1);

        fullname = fullname.toUpperCase();
        User user = new User(fullname, accountNumber, agenceNumber);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);

        String filename = fullname.toUpperCase().replace(" ", "-") + "-" + accountNumber;

        try (FileWriter fileWriter = new FileWriter(dirAccounts + File.separator + filename + ".json")) {
            fileWriter.write(json);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static JsonObject readFile(String fileAccount) {

        String dirAccounts = "src/main/accounts";
        File directory = new File( dirAccounts + File.separator + fileAccount + ".json");

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

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return userAccount; // return JSON user object
    }

}
