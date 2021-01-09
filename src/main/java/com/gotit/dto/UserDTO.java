package com.gotit.dto;

public class UserDTO {

    private String email;
    private String password;
    private String name;
    private String surName;
    private String avatar;

    public UserDTO(String email, String password, String name, String surName, String avatar) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surName = surName;
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
