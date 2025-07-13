package decorator;

import factory.Service;

public class InsuranceDecorator extends ReservationDecorator {

    public InsuranceDecorator(Service decoratedService) {
        super(decoratedService);
    }

    @Override
    public void reserve() {
        super.reserve();
        addInsurance();
    }

    private void addInsurance() {
        System.out.println("Seguro de viaje agregado a la reserva.");
    }
}
