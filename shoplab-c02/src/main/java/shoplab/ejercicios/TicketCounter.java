package shoplab.ejercicios;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TicketCounter
 */
public class TicketCounter {

    private static AtomicInteger counter = new AtomicInteger();

    public TicketCounter() {}

    public int next() {
        return counter.incrementAndGet();
    }
}
