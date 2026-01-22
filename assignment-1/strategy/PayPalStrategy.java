package strategy;

public class PayPalStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal.");
    }
}
