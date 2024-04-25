package com.dio.santanderopenacademy.useraccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
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

        try (FileWriter fileWriter = new FileWriter( fileName)) {
            fileWriter.write(json);
        }catch (Exception e) {
            System.out.println("An error occurred, pleas try again!");
        }

    }

    public static boolean readFile(String cpf) {

        String pathDir = "src/main/accounts";
        File directory = new File(pathDir);

        String userAccountExists = pathDir + File.separator + cpf + ".json";

        if(new File(userAccountExists).exists()) {
            return true;
        }

        return false;
    }

//    public static void main(String[] args) {
//        createFile("olivia dos santos conceicao", "0124564565", "lkSKLADHASDHuhasd",100);
//    }
}
