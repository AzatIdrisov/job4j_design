package ru.job4j.ood.isp;

public class PastryChef implements Cook {

    @Override
    public void cutMeat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fryMeat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void bakeCake() {
        //do smth
    }
}
