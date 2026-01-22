package factory;

import template.DigitalOrder;
import template.Order;
import template.PhysicalOrder;

public class OrderFactory {
    public static Order createOrder(String type) {
        if (type.equalsIgnoreCase("EBOOK"))
            return new DigitalOrder();
        else if (type.equalsIgnoreCase("PHYSICAL"))
            return new PhysicalOrder();
        else
            throw new IllegalArgumentException("unrecognized order format");
    }
}
