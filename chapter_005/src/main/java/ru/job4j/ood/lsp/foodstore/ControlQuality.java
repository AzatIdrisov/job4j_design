package ru.job4j.ood.lsp.foodstore;

import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void distribute(List<Food> foodList) {
        for (Food food : foodList) {
            for (Store store : stores) {
                store.add(food);
            }
        }
    }
}
