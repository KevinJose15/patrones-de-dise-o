package org.example;

import singleton.ReservationSystem;
import factory.*;
import builder.*;
import adapter.*;
import facade.*;
import decorator.*;
import strategy.*;
import observer.*;
import command.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======= SISTEMA DE RESERVAS EASYBOOKING =======\n");

        /*** 🟢 Singleton ***/
        ReservationSystem system = ReservationSystem.getInstance();
        system.showSystemStatus();

        /*** 🟢 Observer: Registro de usuario ***/
        System.out.print("\nIngrese su nombre: ");
        String nombreUsuario = sc.nextLine();

        ReservationSubject subject = new ReservationSubject();
        User user = new User(nombreUsuario);
        subject.addObserver(user);

        subject.notifyObservers("Bienvenido al sistema de reservas.");

        /*** 🟢 Factory Method: Elegir servicio ***/
        System.out.println("\nSeleccione el servicio que desea reservar:");
        System.out.println("1. Hotel\n2. Vuelo\n3. Auto");
        System.out.print("Opción: ");
        int opcionServicio = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        String tipoServicio = "";
        switch (opcionServicio) {
            case 1: tipoServicio = "hotel"; break;
            case 2: tipoServicio = "vuelo"; break;
            case 3: tipoServicio = "auto"; break;
            default: System.out.println("Opción inválida."); return;
        }

        Service servicio = ServiceFactory.createService(tipoServicio);

        /*** 🟢 Adapter: Si es auto, usar servicio externo adaptado ***/
        if (tipoServicio.equals("auto")) {
            ExternalCarRental externalCarRental = new ExternalCarRental();
            servicio = new CarRentalAdapter(externalCarRental);
        }

        /*** 🟢 Decorator: Servicios extra ***/
        System.out.print("\nDesea agregar seguro al servicio? (s/n): ");
        String seguro = sc.nextLine();
        if (seguro.equalsIgnoreCase("s")) {
            servicio = new InsuranceDecorator(servicio);
        }

        System.out.print("Desea agregar wifi extra? (s/n): ");
        String wifi = sc.nextLine();
        if (wifi.equalsIgnoreCase("s")) {
            servicio = new WifiDecorator(servicio);
        }

        /*** 🟢 Strategy: Método de pago ***/
        PaymentContext paymentContext = new PaymentContext();

        System.out.println("\nSeleccione método de pago:");
        System.out.println("1. Tarjeta de Crédito\n2. PayPal\n3. Efectivo");
        System.out.print("Opción: ");
        int opcionPago = sc.nextInt();

        switch (opcionPago) {
            case 1: paymentContext.setPaymentStrategy(new CreditCardPayment()); break;
            case 2: paymentContext.setPaymentStrategy(new PayPalPayment()); break;
            case 3: paymentContext.setPaymentStrategy(new CashPayment()); break;
            default: System.out.println("Opción inválida."); return;
        }

        /*** 🟢 Command: Realizar y cancelar reserva ***/
        ReservationReceiver receiver = new ReservationReceiver();
        Command makeReservationCommand = new MakeReservationCommand(receiver);
        ReservationInvoker invoker = new ReservationInvoker();
        invoker.setCommand(makeReservationCommand);

        System.out.println("\nRealizando su reserva...");
        servicio.reserve();
        paymentContext.pay(100.0); // simulación de pago

        invoker.executeCommand();
        subject.notifyObservers("Su reserva ha sido realizada exitosamente.");

        /*** Opcional: cancelar reserva ***/
        System.out.print("\nDesea cancelar su reserva? (s/n): ");
        sc.nextLine(); // limpiar buffer
        String cancelar = sc.nextLine();
        if (cancelar.equalsIgnoreCase("s")) {
            invoker.undoCommand();
            subject.notifyObservers("Su reserva ha sido cancelada.");
        } else {
            subject.notifyObservers("Gracias por usar EasyBooking.");
        }

        System.out.println("\n======= FIN DEL SISTEMA =======");
        sc.close();
    }
}
