package ru.job4j.ood.lsp.foodstore;

import java.util.Calendar;

public class Milk extends Food {

    public Milk(String name, Calendar expiryDate, Calendar createDate, Double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
