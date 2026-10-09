package shoplab.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * RaceCheck
 */
public class RaceCheck {

    public static void main(String[] args) throws InterruptedException {
        Set<PromoCodeBook> seen = ConcurrentHashMap.newKeySet();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Thread thread = new Thread(
                    () -> seen.add(PromoCodeBook.getInstance()));
            threads.add(thread);
            thread.start();
        }

        for(Thread t : threads) {
            t.join();
        }

        System.out.println("instancias distintas " + seen.size());
        System.out.println("constructor ejecutado: " + 
                PromoCodeBook.CREATED.get() + " veces");
    }
}
