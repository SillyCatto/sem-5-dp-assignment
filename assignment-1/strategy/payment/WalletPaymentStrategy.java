package strategy.payment;

import model.Order;

public class WalletPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(Order order) {
        System.out.println("processing wallet payment of tk" +order.getCartTotal());
        return true;
    }
}
