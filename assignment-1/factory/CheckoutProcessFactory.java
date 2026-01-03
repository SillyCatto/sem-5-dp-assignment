package factory;

import model.Order;
import template.CheckoutProcess;
import template.DigitalOrderCheckout;
import template.PhysicalOrderCheckout;

public class CheckoutProcessFactory {

    public static CheckoutProcess createCheckoutProcess(Order order) {
        if (order.isDigital()) {
            return new DigitalOrderCheckout();
        } else {
            return new PhysicalOrderCheckout();
        }
    }
}
