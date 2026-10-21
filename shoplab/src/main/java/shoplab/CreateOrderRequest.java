package shoplab;

import java.util.List;

/**
 * CreateOrderRequest
 */
public record CreateOrderRequest(List<OrderItemRequest> items, ShippingAddress address, String region, 
        PaymentType paymentType) { }
