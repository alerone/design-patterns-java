package shoplab;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * BankTransferProcessor
 */
public class BankTransferProcessor implements PaymentProcessor{
    private final AtomicInteger sequence = new AtomicInteger();

    @Override
    public PaymentResult charge(Money amount) {
        String transactionId = "transfer-" + sequence.incrementAndGet();
        String message = "waiting for a bank transfer of " + amount.amount() + " " + amount.currency();
        return new PaymentResult(true, transactionId, message);
    }
}
