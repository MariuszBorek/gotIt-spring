package com.gotit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Auction {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String photo;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    private String buyNowPrice;
    private String startMinPrice;
    private boolean promotedAuction;
    private String localization;
    private LocalDate dateOfIssue;
    private LocalDate endDate;
    private int numberOfVisits;
    @OneToOne(mappedBy = "auction")
    private Purchase purchase;
    private boolean isFinished;
    @ManyToMany(mappedBy = "watchedAuctions")
    List<UserAccount> users;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    UserAccount auctionOwner;
    @OneToMany(mappedBy = "auction")
    private List<Offer> offers;
    private boolean isAuction;
    @ManyToMany(mappedBy = "auctions")
    private List<Cart> carts;

    public Auction() {
    }

    public Auction(String title, String description, String photo, Category category, String buyNowPrice, String startMinPrice,
                   boolean promotedAuction, String localization, LocalDate dateOfIssue, LocalDate endDate, int numberOfVisits,
                   boolean isFinished, UserAccount auctionOwner, boolean isAuction) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.category = category;
        this.buyNowPrice = buyNowPrice;
        this.startMinPrice = startMinPrice;
        this.promotedAuction = promotedAuction;
        this.localization = localization;
        this.dateOfIssue = dateOfIssue;
        this.endDate = endDate;
        this.numberOfVisits = numberOfVisits;
        this.isFinished = isFinished;
        this.auctionOwner = auctionOwner;
        this.isAuction = isAuction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(String buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public boolean getPromotedAuction() {
        return promotedAuction;
    }

    public void setPromotedAuction(boolean promotedAuction) {
        this.promotedAuction = promotedAuction;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public UserAccount getAuctionOwner() {
        return auctionOwner;
    }

    public void setAuctionOwner(UserAccount auctionOwner) {
        this.auctionOwner = auctionOwner;
    }

    public boolean isAuction() {
        return isAuction;
    }

    public void setAuction(boolean auction) {
        isAuction = auction;
    }

    public String getStartMinPrice() {
        return startMinPrice;
    }

    public void setStartMinPrice(String startMinPrice) {
        this.startMinPrice = startMinPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return promotedAuction == auction.promotedAuction &&
                numberOfVisits == auction.numberOfVisits &&
                isFinished == auction.isFinished &&
                Objects.equals(id, auction.id) &&
                Objects.equals(title, auction.title) &&
                Objects.equals(description, auction.description) &&
                Objects.equals(photo, auction.photo) &&
                Objects.equals(category, auction.category) &&
                Objects.equals(buyNowPrice, auction.buyNowPrice) &&
                Objects.equals(startMinPrice, auction.startMinPrice) &&
                Objects.equals(localization, auction.localization) &&
                Objects.equals(dateOfIssue, auction.dateOfIssue) &&
                Objects.equals(endDate, auction.endDate) &&
                Objects.equals(purchase, auction.purchase) &&
                Objects.equals(auctionOwner, auction.auctionOwner) &&
                Objects.equals(isAuction, auction.isAuction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, photo, category, buyNowPrice, startMinPrice, promotedAuction,
                localization, dateOfIssue, endDate, numberOfVisits, purchase, isFinished, auctionOwner, isAuction);
    }
}
