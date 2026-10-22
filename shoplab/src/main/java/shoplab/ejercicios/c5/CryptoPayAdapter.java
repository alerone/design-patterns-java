package shoplab.ejercicios.c5;

import shoplab.Money;
import shoplab.PaymentProcessor;
import shoplab.PaymentResult;

/**
 * CryptoPayAdapter
 */
public class CryptoPayAdapter implements PaymentProcessor {
    private final CryptoPayClient client;
    private final String wallet;

    public CryptoPayAdapter(CryptoPayClient client, String wallet) {
        this.client = client; this.wallet = wallet;
    }

    @Override
    public PaymentResult charge(Money amount) {
        try {
            String hash = client.send(wallet, amount.amount().doubleValue());
            return new PaymentResult(true, hash, "");
        } catch (IllegalArgumentException e) {
            return new PaymentResult(false, "", e.getMessage());
        }
    }
}
