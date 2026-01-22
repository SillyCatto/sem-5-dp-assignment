package decorator;
import strategy.PaymentStrategy;


public class LoggingDecorator extends PaymentDecorator {

    public LoggingDecorator(PaymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Logging transaction");
        wrappedStrategy.pay(amount);
    }
}
