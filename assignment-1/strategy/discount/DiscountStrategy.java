package strategy.discount;
import model.Order;


public interface DiscountStrategy {
    double applyDiscount(Order order);
}
