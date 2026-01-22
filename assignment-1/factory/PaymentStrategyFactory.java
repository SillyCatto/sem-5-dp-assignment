package factory;

import strategy.CreditCardStrategy;
import strategy.PayPalStrategy;
import strategy.PaymentStrategy;

public class PaymentStrategyFactory {

    public static PaymentStrategy getPaymentMethod(String method) {
        if (method.equalsIgnoreCase("PAYPAL"))
            return new PayPalStrategy();
        else if (method.equalsIgnoreCase("CREDIT CARD"))
            return new CreditCardStrategy();
        else
            throw new IllegalArgumentException("unrecognized payment option");
    }
}
