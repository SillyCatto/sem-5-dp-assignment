package template;

import model.Order;

public class DigitalOrderCheckout extends CheckoutProcess {
    @Override
    protected void addShipping(Order order) {
        System.out.println("digital product, no shipping required");
    }

    @Override
    protected void fulfill(Order order) {
        generateDownloadLink(order);
        grantLicenseAccess(order);
    }

    private void generateDownloadLink(Order order) {
        System.out.println("download link created www.xyz.com" + order.getOrderId());
    }

    private void grantLicenseAccess(Order order) {
        System.out.println("license activated");
    }
}
