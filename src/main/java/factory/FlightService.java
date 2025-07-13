package factory;

public class FlightService implements Service{
    @Override
    public void reserve() {
        System.out.println("Reserva de Vuelo creada.");
    }
}
