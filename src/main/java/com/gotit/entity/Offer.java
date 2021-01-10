package com.gotit.entity;

import java.util.Objects;

public class Offer {

    private Long id;
    private Auction auction;
    private UserAccount userAccount;
    private double price;

    public Offer() {
    }

    public Offer(Auction auction, UserAccount userAccount, double price) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.price, price) == 0 &&
                Objects.equals(id, offer.id) &&
                Objects.equals(auction, offer.auction) &&
                Objects.equals(userAccount, offer.userAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, auction, userAccount, price);
    }
}
