package strategy.discount;

import model.Order;

public class LoyaltyDiscountStrategy implements DiscountStrategy {
    private static final double LOYALTY_DISCOUNT = 0.10;

    @Override
    public double applyDiscount(Order order) {
        double discount = order.getCartTotal() * LOYALTY_DISCOUNT;
        System.out.println("10% loyalty discount: -tk" + discount);
        return order.getCartTotal() - discount;
    }
}
