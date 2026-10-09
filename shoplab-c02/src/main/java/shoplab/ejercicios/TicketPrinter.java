package shoplab.ejercicios;

import org.springframework.stereotype.Component;

/**
 * TicketPrinter
 */
@Component
public class TicketPrinter {

    private TicketCounter counter;

    public TicketPrinter(TicketCounter counter) {
        this.counter = counter;
    }
    
    public String print(String text) {
        return "ticket " + counter.next() + ": " + text;
    }
    
    public TicketCounter counter() {return counter;}
}
