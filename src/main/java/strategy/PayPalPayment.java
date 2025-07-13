package strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagado $" + amount + " con PayPal.");
    }
}
