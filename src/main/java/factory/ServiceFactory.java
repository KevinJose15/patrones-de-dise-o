package factory;

public class ServiceFactory {
    public static Service createService(String type) {
        switch (type.toLowerCase()) {
            case "hotel":
                return new HotelService();
            case "vuelo":
                return new FlightService();
            case "auto":
                return new CarRentalService();
            default:
                throw new IllegalArgumentException("Tipo de servicio no válido: " + type);
        }
    }
}
