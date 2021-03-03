package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private int id;
    private String name;

    private List<Item> menuItems = new ArrayList<>();

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Item> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Item> menuItems) {
        this.menuItems = menuItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMenuItem(Item item) {
        this.menuItems.add(item);
    }
}
