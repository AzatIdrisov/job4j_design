package ru.job4j.ood.isp.menu;

public class MenuPrinter implements Print {
    private Item parent;

    public MenuPrinter(Item parent) {
        this.parent = parent;
    }

    @Override
    public void print() {
        for (var e : parent.getMenuItems()) {
            System.out.printf("%s Пункт %s %s \n", "---", e.getId() + ".", e.getName());
            printInnerItems(e, "---", e.getId() + ".");
        }
    }

    private void printInnerItems(Item item, String inTab, String number) {
        inTab = inTab + "---";
        for (var element : item.getMenuItems()) {
            StringBuilder outNum = new StringBuilder();
            outNum.append(number).append(element.getId()).append(".");
            System.out.printf("%s Пункт %s %s \n", inTab, outNum, element.getName());
            printInnerItems(element, inTab, outNum.toString());
        }
    }
}
