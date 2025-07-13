package singleton;

public class ReservationSystem {
    private static ReservationSystem instance;

    private ReservationSystem() {
        System.out.println("Sistema de Reservas iniciado...");
    }

    public static ReservationSystem getInstance() {
        if (instance == null) {
            instance = new ReservationSystem();
        }
        return instance;
    }

    public void showSystemStatus() {
        System.out.println("Sistema de Reservas en línea y activo.");
    }
}
