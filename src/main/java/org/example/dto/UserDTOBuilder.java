package org.example.dto;

//The "UserDTOBuilder" class is created in which the "Builder" design pattern is implemented for the
// construction of the "UserDTO" test data.
public class UserDTOBuilder {

    private String name;
    private String email;
    private String password;

    public UserDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserDTOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDTOBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDTO build() {
        return new UserDTO(name, email, password);
    }
}
