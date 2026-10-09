package shoplab.ejercicios;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * DocumentService
 */
@Component 
public class DocumentService {

    private final Map<String, DocumentFormatter> formatters;
    private final DocumentFormatter jsonF;

    public DocumentService(Map<String, DocumentFormatter> formatters,
            @Qualifier("json") DocumentFormatter jsonF) {
        this.formatters = formatters;
        this.jsonF = jsonF;
    }

    public DocumentFormatter formatterFor(String name) {
        DocumentFormatter result = formatters.get(name);
        if (result == null) throw new IllegalArgumentException("unknown format: " + name + ", available: " + formatters.keySet());
        return result;
    }

    public String render(String format, List<String> items) {
        DocumentFormatter formatter = formatterFor(format);
        return formatter.format(items);
    }

    public String renderDefault(List<String> items) {
        return jsonF.format(items);
    }

        
}
