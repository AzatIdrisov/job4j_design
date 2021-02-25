package ru.job4j.ood.lsp.foodstore;

import java.util.Calendar;

public class Meat extends Food {

    public Meat(String name, Calendar expiryDate, Calendar createDate, Double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
