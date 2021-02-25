package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trash implements Store {

    private List<Food> products = new ArrayList<>();

    private final double trashLimit = 100;

    @Override
    public boolean add(Food food) {
        boolean result = false;
        double expirationDaysLeft = expirationDaysLeft(food, Calendar.getInstance());
        if (expirationDaysLeft >= trashLimit) {
            this.products.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> getAll() {
        return products;
    }
}
