package com.gotit.dto;

import java.time.LocalDate;

public class PurchaseDTO {

    private Long auctionId;
    private String title;
    private String description;
    private String photo;
    private String category;
    private String localization;
    private LocalDate endDate;
    private String price;

    public PurchaseDTO() {
    }

    public PurchaseDTO(Long auctionId, String title, String description, String photo, String category, String localization, LocalDate endDate, String price) {
        this.auctionId = auctionId;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.category = category;
        this.localization = localization;
        this.endDate = endDate;
        this.price = price;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public PurchaseDTO setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PurchaseDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PurchaseDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public PurchaseDTO setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public PurchaseDTO setCategory(String category) {
        this.category = category;
        return this;
    }


    public String getLocalization() {
        return localization;
    }

    public PurchaseDTO setLocalization(String localization) {
        this.localization = localization;
        return this;
    }


    public LocalDate getEndDate() {
        return endDate;
    }

    public PurchaseDTO setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }


    public String getPrice() {
        return price;
    }

    public PurchaseDTO setPrice(String price) {
        this.price = price;
        return this;
    }

    public PurchaseDTO build() {
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.auctionId = auctionId;
        purchaseDTO.title = title;
        purchaseDTO.description = description;
        purchaseDTO.photo = photo;
        purchaseDTO.category = category;
        purchaseDTO.localization = localization;
        purchaseDTO.endDate = endDate;
        purchaseDTO.price = price;
        return purchaseDTO;
    }

}