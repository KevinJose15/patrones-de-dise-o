package builder;

public class ConcreteReservationBuilder extends ReservationBuilder {

    @Override
    public void buildClientName(String name) {
        reservation.setClientName(name);
    }

    @Override
    public void buildServiceType(String service) {
        reservation.setServiceType(service);
    }

    @Override
    public void buildDate(String date) {
        reservation.setDate(date);
    }

    @Override
    public void buildPaymentMethod(String payment) {
        reservation.setPaymentMethod(payment);
    }
}