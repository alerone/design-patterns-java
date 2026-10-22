package shoplab.ejercicios.c5;

import java.math.BigDecimal;

import shoplab.Money;
import shoplab.PaymentProcessor;
import shoplab.PaymentResult;

/**
 * CryptoPayCheck
 */
public class CryptoPayCheck {

    public static void main(String[] args) {
        String wallet = "wallet";
        CryptoPayClient client = new CryptoPayClient();
        PaymentProcessor pay = new CryptoPayAdapter(client, wallet);

        PaymentResult result = pay.charge(new Money(new BigDecimal(10.0), "EUR"));
        PaymentResult fail = pay.charge(Money.zero("EUR"));

        System.out.println(result);
        System.out.println(fail);
    }
}
