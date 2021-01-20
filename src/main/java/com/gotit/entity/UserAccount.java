package com.gotit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Address address;
    private LocalDate accountCreationDate;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private String avatar;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @OneToMany(mappedBy = "userAccount", fetch = FetchType.EAGER)
    private List<Purchase> purchased;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "watched_auctions",
            joinColumns = @JoinColumn(name = "userAccount_id"),
            inverseJoinColumns = @JoinColumn(name = "auction_id"))
    List<Auction> watchedAuctions;
    @OneToMany(mappedBy = "auctionOwner", fetch = FetchType.EAGER)
    private List<Auction> listedAuctions;

    public UserAccount() {
    }

    public UserAccount(String email, String password, String name, String surname, Address address, LocalDate accountCreationDate, AccountStatus accountStatus, String avatar, AccountType accountType, List<Auction> watchedAuctions) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.accountCreationDate = accountCreationDate;
        this.accountStatus = accountStatus;
        this.avatar = avatar;
        this.accountType = accountType;
        this.watchedAuctions = watchedAuctions;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDate accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
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

    public List<Auction> getWatchedAuctions() {
        return watchedAuctions;
    }

    public void setWatchedAuctions(List<Auction> watchedAuctions) {
        this.watchedAuctions = watchedAuctions;
    }

    public List<Purchase> getPurchased() {
        return purchased;
    }

    public void setPurchased(List<Purchase> purchased) {
        this.purchased = purchased;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(accountCreationDate, that.accountCreationDate) &&
                accountStatus == that.accountStatus &&
                Objects.equals(avatar, that.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, surname, address, accountCreationDate, accountStatus, avatar);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
