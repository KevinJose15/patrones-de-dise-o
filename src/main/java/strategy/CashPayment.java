package strategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagado $" + amount + " en efectivo.");
    }
}
