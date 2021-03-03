package ru.job4j.ood.isp.menu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartMenuTest {

    private ByteArrayOutputStream outArray = new ByteArrayOutputStream();
    private PrintStream myOut = new PrintStream(outArray);
    private Item parent;

    @Before
    public void before() {
        System.setOut(myOut);
        parent = new Item(0, "parent");
        Item one = new Item(1, "действие 1");
        Item two = new Item(2, "действие 2");
        parent.addMenuItem(one);
        parent.addMenuItem(two);
        Item oneOne = new Item(1, "действие 1.1");
        Item oneTwo = new Item(2, "действие 1.2");
        Item oneThree = new Item(3, "действие 1.3");
        one.addMenuItem(oneOne);
        one.addMenuItem(oneTwo);
        one.addMenuItem(oneThree);
        Item oneThreeOne = new Item(1, "действие 1.3.1");
        oneThree.addMenuItem(oneThreeOne);
    }

    @After
    public void after() {
        System.setOut(System.out);
    }

    @Test
    public void testPrintMenu() {
        MenuPrinter menu = new MenuPrinter(parent);
        menu.print();
        String expected = "--- Пункт 1. действие 1 \n"
                + "------ Пункт 1.1. действие 1.1 \n"
                + "------ Пункт 1.2. действие 1.2 \n"
                + "------ Пункт 1.3. действие 1.3 \n"
                + "--------- Пункт 1.3.1. действие 1.3.1 \n"
                + "--- Пункт 2. действие 2 \n";
        Assert.assertEquals(expected, outArray.toString());
    }

    @Test
    public void whenFindFirstPoint() {
        FindAction findPoint = new FindAction(parent);
        Item actual = findPoint.find("1.");
        String expected = "действие 1";
        Assert.assertEquals(expected, actual.getName());
    }

    @Test
    public void whenFindDeepestPoint() {
        FindAction findPoint = new FindAction(parent);
        Item actual = findPoint.find("1.3.1");
        String expected = "действие 1.3.1";
        Assert.assertEquals(expected, actual.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWeTryFindPointAndPressOnlyLettersThenGetNPE() {
        FindAction findPoint = new FindAction(parent);
        Item actual = findPoint.find("null");
        String expected = "действие 1.3.1";
        Assert.assertNotEquals(expected, actual.getName());
    }
}