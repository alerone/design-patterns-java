package shoplab.ejercicios.ocp;

import java.math.BigDecimal;

/**
 * VipDiscount
 */
public class VipDiscount implements CustomerDiscount{

    @Override
    public boolean appliesTo(String customerType) {
        return customerType.trim().toLowerCase().equals("vip");
    }

    @Override
    public BigDecimal rate() {
        return new BigDecimal("0.20").setScale(2);
    }
}
