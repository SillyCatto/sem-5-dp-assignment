package strategy.payment;

import model.Order;

public interface PaymentStrategy {
    boolean pay(Order order);
}
