package shoplab;

/**
 * PaymentProcessor
 */
public interface PaymentProcessor {

    PaymentResult charge(Money amount);
}
