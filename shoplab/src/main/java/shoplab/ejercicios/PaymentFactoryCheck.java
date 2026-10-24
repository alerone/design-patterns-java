package shoplab.ejercicios;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import shoplab.BankTransferProcessor;
import shoplab.LegacyCardAdapter;
import shoplab.LegacyCardClient;
import shoplab.Money;
import shoplab.PaymentProcessor;
import shoplab.PaymentProcessorFactory;
import shoplab.PaymentType;

/**
 * PaymentFactoryCheck
 */
public class PaymentFactoryCheck {

    public static void main(String[] args) {
        Map<String, PaymentProcessor> processors = new ConcurrentHashMap<>();
        processors.put("card", new LegacyCardAdapter(new LegacyCardClient()));
        processors.put("transfer", new BankTransferProcessor());
        PaymentProcessorFactory factory = new PaymentProcessorFactory(processors);

        Money amount = new Money(new BigDecimal("25.00"), "EUR");
        for (PaymentType t : PaymentType.values()) {
            PaymentProcessor processor = factory.create(t);
            System.out.println(t + " -> " + 
                    processor.getClass().getSimpleName());
            System.out.println(processor.charge(amount));
        }
    }
}
