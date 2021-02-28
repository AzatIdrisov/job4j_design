package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {

    boolean park(Car car);

    boolean parkTruck(Truck truck);

    int getPassengersSize();

    int getTruckSize();

    int getFreePassengersPlaces();

    int getFreeTruckPlaces();

    List<Car> getPassengersCars();

    List<Car> getTruckCars();
}
