package shoplab;

import java.util.List;

/**
 * CreateOrderRequest
 */
public record CreateOrderRequest(List<OrderItemRequest> items, ShippingAddress shippingAddress, String region, 
        PaymentType paymentType) { }
