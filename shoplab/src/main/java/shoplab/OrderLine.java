package shoplab;

/**
 * OrderLine
 */
public record OrderLine(String productId, int quantity, Money unitPrice) {
    public OrderLine {
        if (productId == null || productId.isBlank()) 
            throw new IllegalArgumentException("productId can't be null");
        if (quantity <= 0) 
            throw new IllegalArgumentException("quantity can't be negative");
        if (unitPrice == null) 
            throw new IllegalArgumentException("unitPrice is required");
    }

    public Money subtotal() {
        return unitPrice.times(quantity);
    }
}
