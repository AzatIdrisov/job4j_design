package ru.job4j.ood.lsp.foodstore;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenFoodMovingInWarehouse() {
        List<Store> stores = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Milk("V", new GregorianCalendar(2021, Calendar.MARCH, 30),
                        new GregorianCalendar(2021, Calendar.MARCH, 10), 30.0, 30)));
        ControlQuality control = new ControlQuality(stores);
        control.distribute(listFood);
        Food expected = new Milk("V", new GregorianCalendar(2021, Calendar.MARCH, 30),
                new GregorianCalendar(2021, Calendar.MARCH, 10), 30.0, 30);
        assertThat(stores.get(0).getAll().get(0).getName(), is(expected.getName()));
    }

    @Test
    public void whenFoodMovingInShopWithoutDiscount() {
        List<Store> stores = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Milk("V", new GregorianCalendar(2021, Calendar.MARCH, 30),
                        new GregorianCalendar(2021, Calendar.FEBRUARY, 1), 30.0, 30)));
        ControlQuality control = new ControlQuality(stores);
        control.distribute(listFood);
        Food expected = new Milk("V", new GregorianCalendar(2021, Calendar.MARCH, 30),
                new GregorianCalendar(2021, Calendar.FEBRUARY, 1), 30.0, 30);
        assertThat(stores.get(1).getAll().get(0).getName(), is(expected.getName()));
    }

    @Test
    public void whenFoodMovingInShopWithDiscount() {
        List<Store> stores = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Meat("Meat", new GregorianCalendar(2021, Calendar.MARCH, 10),
                        new GregorianCalendar(2021, Calendar.FEBRUARY, 1), 30.0, 30)));
        ControlQuality control = new ControlQuality(stores);
        control.distribute(listFood);
        double expectedPrice = 30 * (100 - 30) / 100;
        assertThat(stores.get(1).getAll().get(0).getPrice(), is(expectedPrice));
    }

    @Test
    public void whenFoodMovingInTrash() {
        List<Store> stores = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Meat("Meat", new GregorianCalendar(2021, Calendar.FEBRUARY, 10),
                        new GregorianCalendar(2021, Calendar.FEBRUARY, 1), 30.0, 30)));
        ControlQuality control = new ControlQuality(stores);
        control.distribute(listFood);
        Food expected = new Meat("Meat", new GregorianCalendar(2021, Calendar.FEBRUARY, 10),
                new GregorianCalendar(2021, Calendar.FEBRUARY, 1), 30.0, 30);
        assertThat(stores.get(2).getAll().get(0).getName(), is(expected.getName()));
    }

    @Test
    public void whenResortFromWarehouseToTrash() {
        List<Store> stores = Arrays.asList(new Warehouse(), new Shop(), new Trash());
        ArrayList<Food> listFood = new ArrayList<>(List.of(
                new Milk("V", new GregorianCalendar(2021, Calendar.MARCH, 10),
                        new GregorianCalendar(2021, Calendar.MARCH, 1), 30.0, 30)));
        ControlQuality control = new ControlQuality(stores);
        control.distribute(listFood);
        stores.get(0).getAll().get(0).setExpiryDate(new GregorianCalendar(2021, Calendar.MARCH, 2));
        Food expected = new Milk("V", new GregorianCalendar(2021, Calendar.MARCH, 2),
                new GregorianCalendar(2021, Calendar.MARCH, 1), 30.0, 30);
        control.resort();
        assertThat(stores.get(2).getAll().get(0).getName(), is(expected.getName()));
    }

}