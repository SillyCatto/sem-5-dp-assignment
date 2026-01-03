package strategy.shipping;

import model.Order;

public class CarrierShippingStrategy implements ShippingStrategy {
    private static final double BASE_RATE = 100;
    private static final double RATE_MULTIPLIER = 0.05; // 5% of order total

    @Override
    public double calculateShipping(Order order) {
        double shippingCost = BASE_RATE + (order.getCartTotal() * RATE_MULTIPLIER);
        System.out.println("calculating international carrier shiping: tk" +shippingCost);
        return shippingCost;
    }
}
