package shoplab.ejercicios;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TicketCheck implements ApplicationRunner {
    private final TicketPrinter printer;
    private final TicketAudit audit;

    public TicketCheck(TicketPrinter printer, TicketAudit audit) {
        this.printer = printer;
        this.audit = audit;
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("[c02] " + printer.print("camiseta"));
        System.out.println("[c02] " + audit.record("devolucion"));
        System.out.println("[c02] " + printer.print("gorra"));
        System.out.println("[c02] misma instancia: "
                + (printer.counter() == audit.counter()));
        System.out.println("[c02] con new: "
                + (printer.counter() == new TicketCounter()));
    }
}
