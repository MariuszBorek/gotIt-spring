package com.gotit.dto;

public class UserDTO {

    private String email;
    private String password;
    private String name;
    private String surname;
    private String street;
    private String houseNumber;
    private String postcode;
    private String province;
    private String city;
    private String avatar;

    public UserDTO() {
    }

    public UserDTO(String email, String password, String name, String surname, String street, String houseNumber, String postcode, String province, String city, String avatar) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.province = province;
        this.city = city;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
