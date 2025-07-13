package builder;

public class ReservationDirector {
    private ReservationBuilder builder;

    public ReservationDirector(ReservationBuilder builder) {
        this.builder = builder;
    }

    public void constructReservation(String name, String service, String date, String payment) {
        builder.buildClientName(name);
        builder.buildServiceType(service);
        builder.buildDate(date);
        builder.buildPaymentMethod(payment);
    }

    public Reservation getReservation() {
        return builder.getReservation();
    }
}
