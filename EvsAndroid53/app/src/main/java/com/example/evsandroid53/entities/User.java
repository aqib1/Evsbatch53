package com.example.evsandroid53.entities;

public class User {
    private int id;
    private String userName;
    private String userPassword;

    public int getId() {
        return id;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(int id) {
        this.id = id;
    }
}
