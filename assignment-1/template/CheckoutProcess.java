package template;

import factory.DiscountStrategyFactory;
import factory.PaymentStrategyFactory;
import factory.ShippingStrategyFactory;
import model.Order;
import strategy.discount.DiscountStrategy;
import strategy.payment.PaymentStrategy;
import strategy.shipping.ShippingStrategy;

public abstract class CheckoutProcess {

    // the template method for processing order
    public final void processOrder(Order order) {
        System.out.println("checkout for: " + order);

        if (!validate(order)) {
            System.out.println("validation failed");
            return;
        }

        price(order);
        addShipping(order);
        if (!pay(order)) {
            System.out.println("payment failed");
            return;
        }

        fulfill(order);
        notify(order);
        System.out.println("checkout completee");
    }

    protected boolean validate(Order order) {
        if (order.getCartTotal() <= 0) {
            System.out.println("cart empty");
            return false;
        }
        return true;
    }
    protected void price(Order order) {
        System.out.println("original total: tk" + order.getCartTotal());

        DiscountStrategy discountStrategy = DiscountStrategyFactory.createDiscountStrategy(order);
        double discountedTotal = discountStrategy.applyDiscount(order);
        order.setCartTotal(discountedTotal);

        System.out.println("after discount: tk" + order.getCartTotal());
    }

    protected void addShipping(Order order) {
        ShippingStrategy shippingStrategy = ShippingStrategyFactory.createShippingStrategy(order);
        double shippingCost = shippingStrategy.calculateShipping(order);
        order.setCartTotal(order.getCartTotal() + shippingCost);
        System.out.println("total with shipping: tk" + order.getCartTotal());
    }

    protected boolean pay(Order order) {
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.createPaymentStrategy(order);
        boolean success = paymentStrategy.pay(order);
        if (success) {
            System.out.println("payment processed");
        }
        return success;
    }
    protected abstract void fulfill(Order order);
    protected void notify(Order order) {
        System.out.println("confirmation email sent to " + order.getCustomerName());
    }
}
