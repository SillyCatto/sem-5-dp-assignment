package strategy.discount;

import model.Order;

public class CouponDiscountStrategy implements DiscountStrategy {
    private static final double COUPON_DISCOUNT = 0.15;

    @Override
    public double applyDiscount(Order order) {
        double discount = order.getCartTotal() * COUPON_DISCOUNT;
        System.out.println("15% coupon discont: -tk" + discount);
        return order.getCartTotal() - discount;
    }
}
