package com.gotit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private UserAccount userAccount;
    @JsonIgnore
    @ManyToMany
    private List<Auction> auctions;

    public Cart() {
    }

    public Cart(UserAccount userAccount, List<Auction> auctions) {
        this.userAccount = userAccount;
        this.auctions = auctions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(userAccount, cart.userAccount) &&
                Objects.equals(auctions, cart.auctions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userAccount, auctions);
    }
}
