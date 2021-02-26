package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {

    boolean park(Car car);

    int getSize();

    int getFreeSize();

    List<Car> getAllCars();
}
