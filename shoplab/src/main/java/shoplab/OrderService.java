package shoplab;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * OrderService
 */
@Service 
@RequiredArgsConstructor 
public class OrderService {
    private final ProductRepository products;
    private final OrderRepository orders;


    public Order create(CreateOrderRequest rq) {
        Order.OrderBuilder builder = Order.builder()
            .id(UUID.randomUUID().toString())
            .shippingAddress(rq.address())
            .region(rq.region())
            .paymentType(rq.paymentType());
        for (OrderItemRequest item: rq.items()) {
            Product prod = products.findById(item.productId())
                .orElseThrow(() -> new ProductNotFoundException(item.productId()));
            builder.line(new OrderLine(item.productId(), item.quantity(), prod.price()));
        }

        return orders.save(builder.build());
    }

    public Optional<Order> find(String id) {
        return orders.findById(id);
    }

    public Optional<Order> repeat(String id) {
        return orders.findById(id)
            .map(order -> orders.save(
                        order.withId(UUID.randomUUID().toString())));
    }
}
