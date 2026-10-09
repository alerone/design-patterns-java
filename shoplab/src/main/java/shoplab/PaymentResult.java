package shoplab;

/**
 * PaymentResult
 */
public record PaymentResult(boolean success, String transactionId, String message) {
}
