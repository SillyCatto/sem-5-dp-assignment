package decorator;

import strategy.PaymentStrategy;

public class FraudCheckDecorator extends PaymentDecorator {

    public FraudCheckDecorator(PaymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public void pay(double amount) {
        System.out.println("checking fraud transaction");
        wrappedStrategy.pay(amount);
    }
}
