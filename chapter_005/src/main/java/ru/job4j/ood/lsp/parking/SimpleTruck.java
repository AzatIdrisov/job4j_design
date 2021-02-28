package ru.job4j.ood.lsp.parking;

public class SimpleTruck implements Car {

    private int size;

    public SimpleTruck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
