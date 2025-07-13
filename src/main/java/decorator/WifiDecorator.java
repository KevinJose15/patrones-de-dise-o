package decorator;

import factory.Service;

public class WifiDecorator extends ReservationDecorator {

    public WifiDecorator(Service decoratedService) {
        super(decoratedService);
    }

    @Override
    public void reserve() {
        super.reserve();
        addWifi();
    }

    private void addWifi() {
        System.out.println("Servicio de Wifi agregado a la reserva.");
    }
}
