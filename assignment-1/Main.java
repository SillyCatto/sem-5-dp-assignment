import decorator.FraudCheckDecorator;
import decorator.LoggingDecorator;
import factory.OrderFactory;
import factory.PaymentStrategyFactory;
import strategy.PaymentStrategy;
import template.Order;

public class Main {

    public static void main(String[] args) {
        // factory
        Order order = OrderFactory.createOrder("PHYSICAL");

        // decorator
        PaymentStrategy paymentMethod = new FraudCheckDecorator(
                new LoggingDecorator(
                    // factory
                    PaymentStrategyFactory.getPaymentMethod("PAYPAL")
                )
        );

        // set strategy to context class
        order.setPaymentStrategy(paymentMethod);

        System.out.println("processing order");

        // template
        order.processOrder(50.00);
    }
}