package ru.job4j.ood.lsp;

import java.util.Calendar;
import java.util.Random;

public class Predator {

    private int energy;

    public Predator(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    protected boolean validateEnergy(int resource) {
        setEnergy(getEnergy() - resource);
        return this.energy > 0;
    }

    public int hunt(int resource) {
        if (!validateEnergy(resource)) {
            throw new IllegalStateException("Your energy less 0!");
        }
        System.out.println("Hunting");
        int loot = new Random().nextInt(10);
        if (loot < 4) {
            throw new IllegalArgumentException("Unsuccessful hunt");
        }
        setEnergy(getEnergy() + loot);
        return loot;
    }

}

class Owl extends Predator {

    public Owl(int energy) {
        super(energy);
    }

    @Override
    public int hunt(int resource) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 5 || hour > 20) {
            throw new IllegalArgumentException("It's not time for hunting!");
        }
        int loot = new Random().nextInt(10);
        System.out.println("Success hunt");
        return loot;
    }

    public static void main(String[] args) {
        Predator predator = new Owl(10);
        predator.hunt(20);

    }
}
