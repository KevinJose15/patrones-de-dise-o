package builder;

public class Reservation {
    private String clientName;
    private String serviceType;
    private String date;
    private String paymentMethod;

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void showReservation() {
        System.out.println("===== Reserva =====");
        System.out.println("Cliente: " + clientName);
        System.out.println("Servicio: " + serviceType);
        System.out.println("Fecha: " + date);
        System.out.println("Pago: " + paymentMethod);
    }
}
