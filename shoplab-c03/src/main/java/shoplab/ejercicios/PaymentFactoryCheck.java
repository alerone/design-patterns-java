package shoplab.ejercicios;

import java.math.BigDecimal;

import shoplab.Money;
import shoplab.PaymentProcessor;
import shoplab.PaymentProcessorFactory;
import shoplab.PaymentType;

/**
 * PaymentFactoryCheck
 */
public class PaymentFactoryCheck {

    public static void main(String[] args) {
        PaymentProcessorFactory factory = new PaymentProcessorFactory();

        Money amount = new Money(new BigDecimal("25.00"), "EUR");
        for (PaymentType t : PaymentType.values()) {
            PaymentProcessor processor = factory.create(t);
            System.out.println(t + " -> " + 
                    processor.getClass().getSimpleName());
            System.out.println(processor.charge(amount));
        }
    }
}
