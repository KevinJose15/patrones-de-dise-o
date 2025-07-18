package strategy;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        if (strategy != null) {
            strategy.pay(amount);
        } else {
            System.out.println("Método de pago no seleccionado.");
        }
    }
}
