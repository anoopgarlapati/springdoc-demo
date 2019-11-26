package com.dio.demo.springdoc.model;

import com.dio.demo.springdoc.util.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class User {


    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @JsonView(Views.Read.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(Views.Write.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(Views.Read.class)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonView(Views.Read.class)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
