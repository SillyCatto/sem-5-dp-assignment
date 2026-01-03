package decorator;

import model.Order;
import strategy.payment.PaymentStrategy;

public abstract class PaymentStrategyDecorator implements PaymentStrategy {
    protected PaymentStrategy wrappedStrategy;

    public PaymentStrategyDecorator(PaymentStrategy strategy) {
        this.wrappedStrategy = strategy;
    }

    @Override
    public boolean pay(Order order) {
        return wrappedStrategy.pay(order);
    }
}
