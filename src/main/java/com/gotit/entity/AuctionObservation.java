package com.gotit.entity;

import java.util.Objects;

public class AuctionObservation {

    private Long id;
    private Auction auction;
    private UserAccount userAccount;

    public AuctionObservation() {
    }

    public AuctionObservation(Auction auction, UserAccount userAccount) {
        this.auction = auction;
        this.userAccount = userAccount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionObservation that = (AuctionObservation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(auction, that.auction) &&
                Objects.equals(userAccount, that.userAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, auction, userAccount);
    }
}
