package shoplab.ejercicios.ocp;

import java.math.BigDecimal;

/**
 * CustomerDiscount
 */
public interface CustomerDiscount {

    boolean appliesTo(String customerType);
    BigDecimal rate();
}
