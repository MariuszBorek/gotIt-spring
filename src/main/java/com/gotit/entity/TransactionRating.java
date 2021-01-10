package com.gotit.entity;

import java.util.Objects;

public class TransactionRating {

    private Long id;
    private int sellerRating;
    private String sellerComment;
    private int buyerRating;
    private String buyerComment;

    public TransactionRating() {
    }

    public TransactionRating(int sellerRating, String sellerComment, int buyerRating, String buyerComment) {
        this.sellerRating = sellerRating;
        this.sellerComment = sellerComment;
        this.buyerRating = buyerRating;
        this.buyerComment = buyerComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(int sellerRating) {
        this.sellerRating = sellerRating;
    }

    public String getSellerComment() {
        return sellerComment;
    }

    public void setSellerComment(String sellerComment) {
        this.sellerComment = sellerComment;
    }

    public int getBuyerRating() {
        return buyerRating;
    }

    public void setBuyerRating(int buyerRating) {
        this.buyerRating = buyerRating;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionRating that = (TransactionRating) o;
        return sellerRating == that.sellerRating &&
                buyerRating == that.buyerRating &&
                Objects.equals(id, that.id) &&
                Objects.equals(sellerComment, that.sellerComment) &&
                Objects.equals(buyerComment, that.buyerComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sellerRating, sellerComment, buyerRating, buyerComment);
    }
}
