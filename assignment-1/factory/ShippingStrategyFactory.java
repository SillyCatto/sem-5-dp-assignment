package factory;

import model.Order;
import strategy.shipping.CarrierShippingStrategy;
import strategy.shipping.FlatRateShippingStrategy;
import strategy.shipping.ShippingStrategy;

public class ShippingStrategyFactory {

    public static ShippingStrategy createShippingStrategy(Order order) {
        if (order.isInternational()) {
            return new CarrierShippingStrategy();
        } else {
            return new FlatRateShippingStrategy();
        }
    }
}
