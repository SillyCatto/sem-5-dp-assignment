package strategy.payment;

import model.Order;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(Order order) {
        System.out.println("pocessing card payment of tk" + order.getCartTotal());
        return true;
    }
}
