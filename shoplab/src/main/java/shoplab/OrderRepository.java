package shoplab;

import java.util.Optional;

/**
 * OrderRepository
 */
public interface OrderRepository {

    Order save(Order order);
    Optional<Order> findById(String id);
}
