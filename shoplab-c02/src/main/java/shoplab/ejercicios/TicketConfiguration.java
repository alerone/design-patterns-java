package shoplab.ejercicios;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TicketConfiguration
 */
@Configuration 
public class TicketConfiguration {

    @Bean 
    TicketCounter ticketCounter() {
        return new TicketCounter();
    }

    
}
