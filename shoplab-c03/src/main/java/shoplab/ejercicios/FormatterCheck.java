package shoplab.ejercicios;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component 
public class FormatterCheck implements ApplicationRunner {
    private final DocumentService service;

    public FormatterCheck(DocumentService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<String> items = List.of("a", "b", "c");
        System.out.println("[c03] json: "
                + service.render("json", items));
        System.out.println("[c03] csv: "
                + service.render("csv", items));
        System.out.println("[c03] default: "
                + service.renderDefault(items));
        try {
            service.render("xml", items);
        } catch (IllegalArgumentException e) {
            System.out.println("[c03] xml: " + e.getMessage());
        }
    }
}
