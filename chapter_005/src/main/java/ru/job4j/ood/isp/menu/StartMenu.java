package ru.job4j.ood.isp.menu;

public class StartMenu {

    public static void main(String[] args) {
        Item pool = new Item(0, "parent");
        Item one = new Item(1, "действие 1");
        Item two = new Item(2, "действие 2");
        Item three = new Item(3, "действие 3");
        pool.addMenuItem(one);
        pool.addMenuItem(two);
        pool.addMenuItem(three);
        Item oneOne = new Item(1, "действие 1.1");
        Item oneTwo = new Item(2, "действие 1.2");
        Item oneThree = new Item(3, "действие 1.3");
        one.addMenuItem(oneOne);
        one.addMenuItem(oneTwo);
        one.addMenuItem(oneThree);
        Item oneThreeOne = new Item(1, "действие 1.3.1");
        oneThree.addMenuItem(oneThreeOne);
        new Loop().start(new Interaction(), new FindAction(pool), new MenuPrinter(pool));
    }
}
