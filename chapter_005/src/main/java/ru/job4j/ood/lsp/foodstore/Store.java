package ru.job4j.ood.lsp.foodstore;

import java.util.Calendar;
import java.util.List;

public interface Store {

    boolean add(Food food);

    List<Food> getAll();

    default double expirationDaysLeft(Food food, Calendar dateNow) {
        long difference = dateNow.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double daysFromCreate = difference / (24 * 60 * 60 * 1000);
        return daysFromCreate / food.expirationTimeInDay() * 100;
    }
}
