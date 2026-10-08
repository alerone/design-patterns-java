package shoplab.ejercicios.ocp;

import java.math.BigDecimal;

/**
 * PremiumDiscount
 */
public class PremiumDiscount implements CustomerDiscount {

    @Override
    public boolean appliesTo(String customerType) {
        return customerType.trim().toLowerCase().equals("premium");
    }

    @Override
    public BigDecimal rate() {
        return new BigDecimal("0.10").setScale(2);
    }
}
