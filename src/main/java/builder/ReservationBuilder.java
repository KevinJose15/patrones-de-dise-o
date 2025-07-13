package builder;

public abstract class ReservationBuilder {
    protected Reservation reservation = new Reservation();

    public abstract void buildClientName(String name);
    public abstract void buildServiceType(String service);
    public abstract void buildDate(String date);
    public abstract void buildPaymentMethod(String payment);

    public Reservation getReservation() {
        return reservation;
    }
}