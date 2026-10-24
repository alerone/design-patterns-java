package shoplab;

import lombok.RequiredArgsConstructor;

/**
 * FastPayAdapter
 */
@RequiredArgsConstructor 
public class FastPayAdapter implements PaymentProcessor{
    private final FastPayClient client;

    @Override
    public PaymentResult charge(Money amount) {
        FastPayReceipt receipt = 
            client.submit(amount.amount().doubleValue());
        return new PaymentResult(receipt.accepted(),
                receipt.receiptId(),
                receipt.accepted()
                    ? "charged " + amount.amount() + " " 
                    + amount.currency() + " by fastpay" : receipt.reason());
    }

    
}
