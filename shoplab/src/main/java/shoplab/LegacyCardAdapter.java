package shoplab;

import lombok.RequiredArgsConstructor;

/**
 * LegacyCardAdapter
 */
@RequiredArgsConstructor 
public class LegacyCardAdapter implements PaymentProcessor {
    private final LegacyCardClient client;

    @Override
    public PaymentResult charge(Money amount) {
        long cents = amount.amount().movePointRight(2).longValueExact();
        String raw = client.doPayment(cents, amount.currency());
        String[] parts = raw.split("\\|", 2);
        boolean ok = parts[0].equals("OK");

        return new PaymentResult(ok,
                ok ? parts[1] : null, 
                ok ? "charged " + amount.amount() + " " 
                + amount.currency() + " by legacy card" : parts[1]);

    }

    
}
