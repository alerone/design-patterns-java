package shoplab.ejercicios;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * PromoCodeBook
 */
public class PromoCodeBook {
    static final AtomicInteger CREATED = new AtomicInteger();

    private static final class Holder {
        private static final PromoCodeBook INSTANCE = new PromoCodeBook();
    }

    private PromoCodeBook() {
        CREATED.incrementAndGet();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static PromoCodeBook getInstance() {
        return Holder.INSTANCE;
    }

    public boolean isValid(String code) {
        return code.startsWith("PROMO-");
    }
    
}
