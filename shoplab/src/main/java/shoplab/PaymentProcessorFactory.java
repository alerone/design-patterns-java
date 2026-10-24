package shoplab;

import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * PaymentProcessorFactory
 */
@Component 
@RequiredArgsConstructor 
public class PaymentProcessorFactory {

    private final Map<String, PaymentProcessor> processors;

    public PaymentProcessor create(PaymentType type) {
        Objects.requireNonNull(type);
        return switch (type) {
            case CARD -> processor("card");
            case TRANSFER -> processor("transfer");
        };
    }
    private PaymentProcessor processor(String name) {
        PaymentProcessor processor = processors.get(name);
        if (processor == null) {
            throw new IllegalStateException("no PaymentProcessor bean named '" + name + "'");
        }
        return processor;
    }
}
