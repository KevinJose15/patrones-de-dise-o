package factory;

public class CarRentalService implements Service {
    @Override
    public void reserve() {
        System.out.println("Reserva de Auto creada.");
    }
}