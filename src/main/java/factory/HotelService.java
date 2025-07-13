package factory;

public class HotelService implements Service{
    @Override
    public void reserve() {
        System.out.println("Reserva de Hotel creada.");
    }
}
