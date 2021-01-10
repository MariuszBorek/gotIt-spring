package com.gotit.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Auction {

    private Long id;
    private String description;
    private String photo;
    private Category category;
    private String minPrice;
    private String buyNowPrice;
    private boolean promotedAuction;
    private String localization;
    private LocalDate dateOfIssue;
    private LocalDate endDate;
    private int numberOfVisits;

    public Auction() {
    }

    public Auction(String description, String photo, Category category, String minPrice, String buyNowPrice, boolean promotedAuction, String localization, LocalDate dateOfIssue, LocalDate endDate, int numberOfVisits) {
        this.description = description;
        this.photo = photo;
        this.category = category;
        this.minPrice = minPrice;
        this.buyNowPrice = buyNowPrice;
        this.promotedAuction = promotedAuction;
        this.localization = localization;
        this.dateOfIssue = dateOfIssue;
        this.endDate = endDate;
        this.numberOfVisits = numberOfVisits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(String buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public boolean isPromotedAuction() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return promotedAuction == auction.promotedAuction &&
                numberOfVisits == auction.numberOfVisits &&
                Objects.equals(id, auction.id) &&
                Objects.equals(description, auction.description) &&
                Objects.equals(photo, auction.photo) &&
                Objects.equals(category, auction.category) &&
                Objects.equals(minPrice, auction.minPrice) &&
                Objects.equals(buyNowPrice, auction.buyNowPrice) &&
                Objects.equals(localization, auction.localization) &&
                Objects.equals(dateOfIssue, auction.dateOfIssue) &&
                Objects.equals(endDate, auction.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, photo, category, minPrice, buyNowPrice, promotedAuction, localization, dateOfIssue, endDate, numberOfVisits);
    }
}