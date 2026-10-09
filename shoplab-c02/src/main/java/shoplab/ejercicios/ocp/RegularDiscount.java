package shoplab.ejercicios.ocp;

import java.math.BigDecimal;

/**
 * RegularDiscount
 */
public class RegularDiscount implements CustomerDiscount{

    @Override
    public boolean appliesTo(String customerType) {
        return customerType.trim().toLowerCase().equals("regular");
    }

    @Override
    public BigDecimal rate() {
        return BigDecimal.ZERO;
    }
}
