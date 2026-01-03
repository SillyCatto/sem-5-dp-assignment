package strategy.shipping;
import model.Order;

public class FlatRateShippingStrategy implements ShippingStrategy {
    private static final double FLAT_RATE = 60.00;
    @Override
    public double calculateShipping(Order order) {
        System.out.println("calculating flat rate domestic shipping: tk" +FLAT_RATE);
        return FLAT_RATE;
    }
}
