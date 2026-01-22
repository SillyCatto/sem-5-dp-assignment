package template;

import strategy.PaymentStrategy;

public abstract class Order {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public final void processOrder(double amount) {
        validate();

        if (paymentStrategy == null)
            throw new RuntimeException("no payment method selected");
        paymentStrategy.pay(amount);

        deliver();
    }

    protected void validate() {
        System.out.println("validating cart");
    }

    protected abstract void deliver();
}
