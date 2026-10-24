package shoplab;

/**
 * CheckoutResult
 */
public record CheckoutResult(String orderId, Money amount, PaymentResult payment) {
}
