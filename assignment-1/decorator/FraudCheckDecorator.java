package decorator;

import model.Order;

import strategy.payment.PaymentStrategy;

// fraud detection check before processing payment
public class FraudCheckDecorator extends PaymentStrategyDecorator {

    public FraudCheckDecorator(PaymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public boolean pay(Order order) {
        if (!performFraudCheck(order)) {
            System.out.println("payment blokced, fraud detected");
            return false;
        }
        return super.pay(order);
    }

    private boolean performFraudCheck(Order order) {
        System.out.println("running fraud detection check");
        System.out.println("Fraud check passed");
        return true;
    }
}
