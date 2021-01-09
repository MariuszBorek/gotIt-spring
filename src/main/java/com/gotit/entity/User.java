package com.gotit.entity;

import com.gotit.enumerate.AccountType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surName;
    private String accountDescription;
    private LocalDate accountCreationDate;
    private String avatar;
    private AccountType accountType;

    public User() {
    }

    public User(String email, String password, String name, String surName, String accountDescription, LocalDate accountCreationDate, String avatar, AccountType accountType) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surName = surName;
        this.accountDescription = accountDescription;
        this.accountCreationDate = accountCreationDate;
        this.avatar = avatar;
        this.accountType = accountType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDate accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surName, user.surName) &&
                Objects.equals(accountDescription, user.accountDescription) &&
                Objects.equals(accountCreationDate, user.accountCreationDate) &&
                Objects.equals(avatar, user.avatar) &&
                accountType == user.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, surName, accountDescription, accountCreationDate, avatar, accountType);
    }
}
