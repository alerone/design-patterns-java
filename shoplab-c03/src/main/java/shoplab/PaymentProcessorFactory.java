package shoplab;

import java.util.Objects;

/**
 * PaymentProcessorFactory
 */
public class PaymentProcessorFactory {

    public PaymentProcessorFactory() {}

    public PaymentProcessor create(PaymentType type) {
        Objects.requireNonNull(type);
        return switch (type) {
            case CARD -> new CardProcessor();
            case TRANSFER -> new BankTransferProcessor();
        };
    }
}
