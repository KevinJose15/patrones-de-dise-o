package adapter;
import factory.Service;
import factory.ServiceFactory;
public class ReservationFacade {
    public void makeReservation(String serviceType) {
        Service service = ServiceFactory.createService(serviceType);
        service.reserve();
        System.out.println("Proceso de reserva completado con Facade.\n");
    }
}
