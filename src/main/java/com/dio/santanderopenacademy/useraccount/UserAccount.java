package com.dio.santanderopenacademy.useraccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;


public class UserAccount {

    public static void createFile(String username, String cpf, String password) {

        User user = new User( username, cpf, password);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);
        String pathDir = "src/main/accounts";

        File directory = new File(pathDir);

        if (!directory.exists()) {
            directory.mkdir();
        }

        String fileName = pathDir + File.separator + user.cpf + ".json";

        try (FileWriter fileWriter = new FileWriter( fileName)) {
            fileWriter.write(json);
        }catch (Exception e) {
            System.out.println("An error occurred, pleas try again!");
        }

    }

//    public static void main(String[] args) {
//        createFile("olivia dos santos conceicao", "01242576231", "lkSKLADHASDHuhasd");
//    }
}
