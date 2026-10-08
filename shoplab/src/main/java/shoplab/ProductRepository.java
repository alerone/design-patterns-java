package shoplab;

import java.util.List;
import java.util.Optional;

/**
 * ProductRepository
 */
public interface ProductRepository {

   Product save(Product product);
   Optional<Product> findById(String id);
   List<Product> findAll();
}
