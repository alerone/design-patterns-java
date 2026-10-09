package shoplab;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * InMemoryRepository
 */
@Component 
public class InMemoryRepository implements ProductRepository {
    private static Map<String, Product> store = new ConcurrentHashMap<>();

    @Override
    public Product save(Product product) {
        store.put(product.id(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.of(store.get(id));
    }

    @Override
    public List<Product> findAll() {
        return List.copyOf(store.values());
    }
}
