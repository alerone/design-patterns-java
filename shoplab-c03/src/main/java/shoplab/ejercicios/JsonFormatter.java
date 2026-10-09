package shoplab.ejercicios;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * JsonFormatter
 */
@Component("json")
public class JsonFormatter implements DocumentFormatter{

    @Override
    public String format(List<String> items) {
        String result = "[";
        for (int i = 0; i < items.size() - 1; i++) {
            String item = "\"" + items.get(i) + "\",";
            result = result.concat(item);
        }
        String last = "\"" + items.get(items.size() - 1) + "\"";
        result = result.concat(last + "]");
        return result;
    }
}
