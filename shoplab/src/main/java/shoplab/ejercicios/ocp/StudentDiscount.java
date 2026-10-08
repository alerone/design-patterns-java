package shoplab.ejercicios.ocp;

import java.math.BigDecimal;

/**
 * StudentDiscount
 */
public class StudentDiscount implements CustomerDiscount{

    @Override
    public boolean appliesTo(String customerType) {
        return customerType.trim().toLowerCase().equals("student");
    }

    @Override
    public BigDecimal rate() {
        return new BigDecimal("0.15").setScale(2);
    }
}
