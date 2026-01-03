package strategy.discount;

import model.Order;

public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(Order order) {
        System.out.println("no discount applied");
        return order.getCartTotal();
    }
}
