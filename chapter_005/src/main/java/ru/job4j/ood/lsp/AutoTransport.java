package ru.job4j.ood.lsp;

public class AutoTransport {
    private float fluel;

    public AutoTransport(float fluel) {
        this.fluel = fluel;
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance");
        }
        if (fluel < 0) {
            throw new IllegalArgumentException("Need more fuel");
        }
        // logic
    }
}

class Bus extends AutoTransport {

    private float fuel;

    public Bus(float fuel) {
        super(fuel);
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 5) { // условие усилино
            throw new IllegalArgumentException("Need more fuel!");
        }
        // other logic
    }

}

class FirstRule {
    public static void main(String[] args) {
        AutoTransport bus = new Bus(3);
        bus.move(3);
    }
}
