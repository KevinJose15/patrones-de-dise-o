package strategy;

public class CreditCardPayment  implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagado $" + amount + " con Tarjeta de Crédito.");
    }
}

