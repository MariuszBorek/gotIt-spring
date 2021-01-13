package com.gotit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Purchase {

    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    private Auction auction;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private UserAccount userAccount;
    private String price;

    public Purchase() {
    }

    public Purchase(Auction auction, UserAccount userAccount, String price) {
        this.auction = auction;
        this.userAccount = userAccount;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id) &&
                Objects.equals(price, purchase.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }
}
