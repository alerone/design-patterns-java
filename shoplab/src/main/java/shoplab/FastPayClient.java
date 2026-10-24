package shoplab;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

/**
 * FastPayClient
 */
@Component 
public class FastPayClient {

    private final AtomicInteger counter = new AtomicInteger();

    public FastPayReceipt submit(double euros) {
        if (euros <= 0) {
            return new FastPayReceipt(false, null, "invalid amount");
        }
        return new FastPayReceipt(true, "FP-" + counter.incrementAndGet(), "accepted");
    } 
}
