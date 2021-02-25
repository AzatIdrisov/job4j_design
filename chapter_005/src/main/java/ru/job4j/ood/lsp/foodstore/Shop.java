package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shop implements Store {

    private List<Food> products = new ArrayList<>();

    private final int lowerLimit = 25;
    private final int discountLimit = 75;
    private final int trashLimit = 100;

    @Override
    public boolean add(Food food) {
        boolean result = false;
        double expirationDaysLeft = expirationDaysLeft(food, Calendar.getInstance());
        if (expirationDaysLeft >= lowerLimit && expirationDaysLeft < discountLimit) {
            this.products.add(food);
            result = true;
        } else if (expirationDaysLeft >= discountLimit && expirationDaysLeft < trashLimit) {
            food.setDiscount();
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
