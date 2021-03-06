package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleParkingTest {

    @Test
    public void whenParkPassengerCar() {
        Parking parking = new SimpleParking(10, 5);
        Car car = new PassengerCar();
        parking.park(car);
        assertThat(parking.getPassengersCars().get(0), is(car));
    }

    @Test
    public void whenParkTruckCarOnTruckPlace() {
        Parking parking = new SimpleParking(10, 5);
        Truck truck = new SimpleTruck(5);
        parking.parkTruck(truck);
        assertThat(parking.getTruckCars().get(0), is(truck));
    }

    @Test
    public void whenParkTruckCarOnPassengersPlace() {
        Parking parking = new SimpleParking(10, 0);
        Truck truck = new SimpleTruck(5);
        parking.parkTruck(truck);
        assertThat(parking.getFreePassengersPlaces(), is(5));
    }

    @Test (expected = IllegalStateException.class)
    public void whenNotEnoughParkingPlaces() {
        Parking parking = new SimpleParking(10, 0);
        Truck truck = new SimpleTruck(15);
        parking.parkTruck(truck);
        assertThat(parking.getFreePassengersPlaces(), is(0));
    }

}