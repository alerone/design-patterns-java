package shoplab;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

/**
 * LegacyCardClient
 */
@Component 
public class LegacyCardClient {

    private final AtomicInteger counter = new AtomicInteger();

    public String doPayment(long amountInCents, String currencyCode) {
        if (amountInCents <= 0) {
            return "KO|invalid amount";
        }
        return "OK|LC-" + counter.incrementAndGet();
    }

    
}
