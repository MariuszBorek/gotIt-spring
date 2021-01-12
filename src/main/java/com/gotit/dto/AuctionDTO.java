package com.gotit.dto;


import java.time.LocalDate;

public class AuctionDTO {

    private Long id;
    private String title;
    private String description;
    private String photo;
    private String category;
    private String minPrice;
    private String buyNowPrice;
    private boolean promotedAuction;
    private String localization;
    private LocalDate dateOfIssue;
    private LocalDate endDate;
    private int numberOfVisits;

    public AuctionDTO() {
    }

    public AuctionDTO(String title, Long id, String description, String photo, String category, String minPrice, String buyNowPrice, boolean promotedAuction, String localization, LocalDate dateOfIssue, LocalDate endDate, int numberOfVisits) {
        this.id = id;
        this.title = title;
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

    public AuctionDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AuctionDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AuctionDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public AuctionDTO setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public AuctionDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public AuctionDTO setMinPrice(String minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public String getBuyNowPrice() {
        return buyNowPrice;
    }

    public AuctionDTO setBuyNowPrice(String buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
        return this;
    }

    public boolean isPromotedAuction() {
        return promotedAuction;
    }

    public AuctionDTO setPromotedAuction(boolean promotedAuction) {
        this.promotedAuction = promotedAuction;
        return this;
    }

    public String getLocalization() {
        return localization;
    }

    public AuctionDTO setLocalization(String localization) {
        this.localization = localization;
        return this;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public AuctionDTO setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public AuctionDTO setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public AuctionDTO setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
        return this;
    }

    public AuctionDTO build() {
        AuctionDTO auctionDTO = new AuctionDTO();
        auctionDTO.id = id;
        auctionDTO.title = title;
        auctionDTO.description = description;
        auctionDTO.photo = photo;
        auctionDTO.category = category;
        auctionDTO.minPrice = minPrice;
        auctionDTO.buyNowPrice = buyNowPrice;
        auctionDTO.promotedAuction = promotedAuction;
        auctionDTO.localization = localization;
        auctionDTO.dateOfIssue = dateOfIssue;
        auctionDTO.endDate = endDate;
        auctionDTO.numberOfVisits = numberOfVisits;
        return auctionDTO;
    }
}
