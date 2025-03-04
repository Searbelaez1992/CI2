package org.example.dto;

//The UserDTO class is created in which we implement the "DTO" design pattern in which we will simplify the management
// of the website's user data. This represents the user data that will be passed between the layers.
public class UserDTO {

    private String name;
    private String email;
    private String password;

    public UserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() { return password; }
}
