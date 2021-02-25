package ru.job4j.ood.lsp.foodstore;

import java.util.Calendar;

public class Food {

    private String name;
    private Calendar expiryDate;
    private Calendar createDate;
    private Double price;
    private int discount;

    public Food(String name, Calendar expiryDate, Calendar createDate, Double price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount() {
        this.price = price * (100 - discount) / 100;
    }

    int expirationTimeInDay() {
        long difference = this.expiryDate.getTimeInMillis() - createDate.getTimeInMillis();
        return (int) (difference / (24 * 60 * 60 * 1000));
    }
}
