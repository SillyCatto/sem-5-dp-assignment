package factory;

import decorator.FraudCheckDecorator;
import decorator.LoggingDecorator;
import model.Order;

import strategy.payment.CardPaymentStrategy;
import strategy.payment.PaymentStrategy;

import strategy.payment.WalletPaymentStrategy;



public class PaymentStrategyFactory {

    public static PaymentStrategy createPaymentStrategy(Order order) {
        // base strategy based on payment method
        PaymentStrategy strategy;

        switch (order.getPaymentMethod().toUpperCase()) {
            case "WALLET":
                strategy = new WalletPaymentStrategy();
                break;
            case "CARD":
            default:
                strategy = new CardPaymentStrategy();
                break;
        }

        strategy = new LoggingDecorator(strategy);

        // add fraud check for high risk ordrs
        if (order.isHighRisk()) {
            strategy = new FraudCheckDecorator(strategy);
        }

        return strategy;
    }
}
