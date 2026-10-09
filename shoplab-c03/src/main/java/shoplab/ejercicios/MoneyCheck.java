package shoplab.ejercicios;

import java.math.BigDecimal;
import shoplab.Money;

public class MoneyCheck {

    public static void main(String[] args) {
        Money price = new Money(new BigDecimal("19.99"), "EUR");
        System.out.println(price);
        System.out.println(price.plus(price));
        System.out.println(price.times(3));
        System.out.println(price.times(new BigDecimal("0.21")));
        System.out.println(price.minus(price));
        System.out.println(Money.zero("EUR").equals(price.minus(price)));
        try {
            price.minus(price.times(2));
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getClass().getSimpleName());
        }
        try {
            price.plus(Money.zero("USD"));
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getClass().getSimpleName());
        }
    }
}
