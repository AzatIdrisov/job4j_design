package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {

    private int passengerSize;
    private int truckSize;
    private List<Car> passengersCars = new ArrayList<>();
    private List<Car> trucks = new ArrayList<>();

    public SimpleParking(int passengerSize, int truckSize) {
        this.passengerSize = passengerSize;
        this.truckSize = truckSize;
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public boolean parkTruck(Truck truck) {
        return false;
    }

    @Override
    public int getPassengersSize() {
        return 0;
    }

    @Override
    public int getTruckSize() {
        return 0;
    }

    @Override
    public int getFreePassengersPlaces() {
        return 0;
    }

    @Override
    public int getFreeTruckPlaces() {
        return 0;
    }

    @Override
    public List<Car> getPassengersCars() {
        return null;
    }

    @Override
    public List<Car> getTruckCars() {
        return null;
    }
}
