package shoplab;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Money
 */
public record Money(BigDecimal amount, String currency) {
    private static final int SCALE = 2;
    public Money {
        Objects.nonNull(amount);
        Objects.nonNull(currency);
        if (amount.signum() < 0) throw new IllegalArgumentException("El dinero no puede tener una cantidad negativa.");
        if (currency.isBlank()) throw new IllegalArgumentException("El nombre de la moneda no puede estar vacío.");

        amount = amount.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public static Money zero(String currency) {
        return new Money(BigDecimal.ZERO, currency);
    }

    public Money plus(Money o) {
        if (!currency.equals(o.currency)) throw new IllegalArgumentException("Las monedas deben coincidir.");
        return new Money(amount.add(o.amount()), currency);
    }

    public Money minus(Money o) {
        if (!currency.equals(o.currency)) throw new IllegalArgumentException("Las monedas deben coincidir.");
        return new Money(amount.subtract(o.amount()), currency);
    }

    public Money times(int prod) {
        return new Money(amount.multiply(BigDecimal.valueOf(prod)), currency);
    } 
    public Money times(BigDecimal prod) {
        return new Money(amount.multiply(prod), currency);
    }
}
