package adapter;

import factory.Service;

public class CarRentalAdapter implements Service {
    private ExternalCarRental externalCarRental;

    public CarRentalAdapter(ExternalCarRental externalCarRental) {
        this.externalCarRental = externalCarRental;
    }

    @Override
    public void reserve() {
        externalCarRental.makeCarBooking();
    }
}