package shoplab.ejercicios;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FormatterConfig
 */
@Configuration 
public class FormatterConfig {

    @Bean("csv")
    DocumentFormatter csvFormatter() {
        return new CsvFormatter();
    }
    
}
