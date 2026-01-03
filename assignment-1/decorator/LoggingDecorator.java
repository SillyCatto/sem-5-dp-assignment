package decorator;
import model.Order;
import strategy.payment.PaymentStrategy;


public class LoggingDecorator extends PaymentStrategyDecorator {


    public LoggingDecorator(PaymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public boolean pay(Order order) {
        logBefore(order);
        boolean result = super.pay(order);
        logAfter(order, result);
        return result;
    }

    private void logBefore(Order order) {
        System.out.println("audit: starting payment for Order: " + order.getOrderId() +
                          ", Amount: tk" + order.getCartTotal());
    }
    private void logAfter(Order order, boolean success) {
        String status = success ? "SUCCESS" : "FAILED";
        System.out.println("audit: payment " + status + " for Order: " + order.getOrderId());
    }
}
