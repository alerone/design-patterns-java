package shoplab;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CardProcessor
 */
public class CardProcessor implements PaymentProcessor{
    private final AtomicInteger sequence = new AtomicInteger();

    @Override
    public PaymentResult charge(Money amount) {
        String transactionId = "card-" + sequence.incrementAndGet();
        String message = "charged " + amount.amount() + " " + amount.currency() + " by card";
        return new PaymentResult(true, transactionId, message);
    }
}
