import factory.CheckoutProcessFactory;
import model.Order;

/**
 * E-Commerce Checkout System Demo
 *
 * 1. TEMPLATE METHOD: CheckoutProcess defines the checkout algorithm skeleton
 *    - processOrder() is the template method with fixed steps
 *    - Subclasses (Physical/Digital) customize specific steps
 *
 * 2. STRATEGY: Interchangeable algorithms for payment, discount, and shipping
 *    - PaymentStrategy (Card, Wallet)
 *    - DiscountStrategy (Coupon, Loyalty, None)
 *    - ShippingStrategy (FlatRate, Carrier)
 *
 * 3. FACTORY: Creates appropriate strategies and checkout processes
 *    - CheckoutProcessFactory (creates Physical/Digital checkout)
 *    - PaymentStrategyFactory
 *    - DiscountStrategyFactory
 *    - ShippingStrategyFactory
 *
 * 4. DECORATOR: Adds optional behavior to payment processing
 *    - LoggingDecorator (audit logging)
 *    - FraudCheckDecorator (fraud detection for high-risk orders)
 */
public class Main {

    public static void main(String[] args) {
        // scenario 1: domestic physical order with copon discount
        Order order1 = new Order("ORD-001", "ABC", 150.00);
        order1.setDigital(false);
        order1.setInternational(false);
        order1.setDiscountType("COUPON");
        order1.setPaymentMethod("CARD");
        order1.setHighRisk(false);

        CheckoutProcessFactory.createCheckoutProcess(order1).processOrder(order1);

        // scenario 2: intrenational physical order with loyality discount, order has high risk
        Order order2 = new Order("ORD-002", "XYZ", 1000.00);
        order2.setDigital(false);
        order2.setInternational(true);
        order2.setDiscountType("LOYALTY");
        order2.setPaymentMethod("CARD");
        order2.setHighRisk(true);  // triggers FraudCheckDecorator

        CheckoutProcessFactory.createCheckoutProcess(order2).processOrder(order2);

        // scenario 3: digital product order with walet payment
        Order order3 = new Order("ORD-003", "PQR", 50.00);
        order3.setDigital(true);
        order3.setInternational(false);
        order3.setDiscountType("NONE");
        order3.setPaymentMethod("WALLET");
        order3.setHighRisk(false);

        CheckoutProcessFactory.createCheckoutProcess(order3).processOrder(order3);
    }
}