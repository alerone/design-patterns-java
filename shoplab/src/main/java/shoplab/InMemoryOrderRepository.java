package shoplab;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * InMemoryOrderRepository
 */
@Component 
public class InMemoryOrderRepository implements OrderRepository{

    private final Map<String, Order> orders = new ConcurrentHashMap<>();
    @Override
    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orders.get(id));
    }

    
}
