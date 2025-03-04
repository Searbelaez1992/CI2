package org.example.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import org.example.dto.UserDTO;


public class JsonDataReader {
    private final String userFilePath ="/home/sebastian_arbelaez/Downloads/Modulo 4/1 Intento/spring-boot-web-api-book-shop-module2/src/test/resources/Users.json";
    private List<UserDTO> userList;

    public JsonDataReader(){
        userList = getCustomerData();
    }

    private List<UserDTO> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(userFilePath));
            UserDTO[] users = gson.fromJson(bufferReader, UserDTO[].class);
            return Arrays.asList(users);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + userFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final UserDTO getUserByName(String userName){
        return userList.stream().filter(x -> x.getName().equalsIgnoreCase(userName)).findAny().get();
    }


}