package template;
import model.Order;
public class PhysicalOrderCheckout extends CheckoutProcess {

    @Override
    protected void fulfill(Order order) {
        reserveInventory(order);
        prepareForShipping(order);
    }

    private void reserveInventory(Order order) {
        System.out.println("inventory reserved");
    }

    private void prepareForShipping(Order order) {
        if (order.isInternational()) {
            System.out.println("process international shipping");
        }
        System.out.println("ready");
    }
}
