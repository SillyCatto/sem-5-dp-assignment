package model;

// order data model
public class Order{
    private String orderId;
    private String customerName;
    private double cartTotal;
    private boolean isInternational;
    private boolean isDigital;
    private boolean isHighRisk;
    private String discountType; // COUPON, LOYALTY, NONE
    private String paymentMethod; // CARD or WALLET

    public Order(String orderId, String customerName, double cartTotal) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.cartTotal = cartTotal;

        this.isInternational = false;
        this.isDigital = false;

        this.isHighRisk = false;

        this.discountType = "NONE";
        this.paymentMethod = "CARD";
    }

    public String getOrderId() {
        return orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getCartTotal() { return cartTotal; }
    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public boolean isInternational() {
        return isInternational;
    }
    public void setInternational(boolean international) {
        isInternational = international;
    }

    public boolean isDigital() {
        return isDigital;
        }
    public void setDigital(boolean digital) { isDigital = digital; }
    public boolean isHighRisk() {
        return isHighRisk;
    }


    public void setHighRisk(boolean highRisk) { isHighRisk = highRisk; }
    public String getDiscountType() {
        return discountType;
    }
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getPaymentMethod() { return paymentMethod; }


    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{id='" + orderId + "', customer='" + customerName +
               "', total=$" + cartTotal + "}";
    }
}
