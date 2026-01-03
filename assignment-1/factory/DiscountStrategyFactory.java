package factory;

import model.Order;
import strategy.discount.CouponDiscountStrategy;
import strategy.discount.DiscountStrategy;
import strategy.discount.LoyaltyDiscountStrategy;
import strategy.discount.NoDiscountStrategy;

public class DiscountStrategyFactory {

    public static DiscountStrategy createDiscountStrategy(Order order) {
        switch (order.getDiscountType().toUpperCase()) {
            case "COUPON":
                return new CouponDiscountStrategy();
            case "LOYALTY":
                return new LoyaltyDiscountStrategy();
            case "NONE":
            default:
                return new NoDiscountStrategy();
        }
    }
}
