package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {

    private int passengerSize;
    private int truckSize;
    private int freePassengersPlaces;
    private int freeTrucksPlaces;
    private List<Car> passengersCars = new ArrayList<>();
    private List<Car> trucks = new ArrayList<>();

    public SimpleParking(int passengerSize, int truckSize) {
        this.passengerSize = passengerSize;
        this.truckSize = truckSize;
        this.freePassengersPlaces = passengerSize;
        this.freeTrucksPlaces = truckSize;
    }

    @Override
    public boolean park(Car car) {
        if (getFreePassengersPlaces() == 0) {
            throw new IllegalStateException("There is no places for passengers car");
        }
        this.passengersCars.add(car);
        this.freePassengersPlaces--;
        return true;
    }

    @Override
    public boolean parkTruck(Truck truck) {
        if (getFreeTruckPlaces() != 0) {
            trucks.add(truck);
            this.freeTrucksPlaces--;
        } else if (truck.getSize() <= getFreePassengersPlaces()) {
            trucks.add(truck);
            this.freePassengersPlaces = this.freePassengersPlaces - truck.getSize();
        } else {
            throw new IllegalStateException("There is no places for trucks");
        }
        return true;
    }

    @Override
    public int getPassengersSize() {
        return this.passengerSize;
    }

    @Override
    public int getTruckSize() {
        return this.truckSize;
    }

    @Override
    public int getFreePassengersPlaces() {
        return this.freePassengersPlaces;
    }

    @Override
    public int getFreeTruckPlaces() {
        return this.freeTrucksPlaces;
    }

    @Override
    public List<Car> getPassengersCars() {
        return this.passengersCars;
    }

    @Override
    public List<Car> getTruckCars() {
        return this.trucks;
    }
}
