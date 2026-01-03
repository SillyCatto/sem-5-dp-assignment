package strategy.shipping;
import model.Order;

public interface ShippingStrategy {
    double calculateShipping(Order order);
}
