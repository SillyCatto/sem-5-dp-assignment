package strategy;

public class CreditCardStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card.");
    }
}
