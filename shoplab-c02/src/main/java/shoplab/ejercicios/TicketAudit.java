package shoplab.ejercicios;

import org.springframework.stereotype.Component;

/**
 * TicketAudit
 */
@Component 
public class TicketAudit {

    private TicketCounter counter;

    public TicketAudit(TicketCounter counter) { this.counter = counter; }

    public String record(String action) {
        return "audit " + counter.next() + ": "  + action;
    }
    
    public TicketCounter counter() {return counter;}
}
