package shoplab.ejercicios.c5;

/**
 * CryptoPayClient
 */
public class CryptoPayClient {

    public String send(String wallet, double euros) {
        if (wallet == null || wallet.isBlank()) {
            throw new IllegalArgumentException("wallet is required");
        }
        if (euros <= 0) {
            throw new IllegalArgumentException("euros must be positive");
        }
        return "0x" + Integer.toHexString((wallet + euros).hashCode());
    }
}
