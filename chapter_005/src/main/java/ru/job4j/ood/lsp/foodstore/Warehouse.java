package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> products = new ArrayList<>();

    private final int limit = 25;

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (expirationDaysLeft(food, Calendar.getInstance()) < limit) {
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
