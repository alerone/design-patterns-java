package shoplab;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

/**
 * MoneyTest
 */
class MoneyTest {

    @Test
    void plusAddsAmountInTheSameCurrency() {
        Money a = new Money(new BigDecimal("10.50"), "EUR");
        Money b = new Money(new BigDecimal("4.50"), "EUR");

        Money sum = a.plus(b);

        assertEquals(new Money(new BigDecimal("15.0"), "EUR"), sum);
    }

    @Test
    void plusRejectsDifferentCurrencies() {
        Money euros = new Money(new BigDecimal("10.00"), "EUR");
        Money pounds = new Money(new BigDecimal("10.00"), "GBP");
        assertThrows(IllegalArgumentException.class,
                () -> euros.plus(pounds));
    }

    @Test
    void timesRoundsToTwoDecimals() {
        Money price = new Money(new BigDecimal("49.90"), "EUR");
        Money tax = price.times(new BigDecimal("0.21"));
        assertEquals(new Money(new BigDecimal("10.48"), "EUR"), tax);
    }
}
