package shoplab;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController
 */
@RequestMapping("/products")
@RestController 
public class ProductController {

    private final InMemoryRepository repo;

    public ProductController() { this.repo = new InMemoryRepository(); }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product prod) {
        return repo.save(prod);
    }    

    @GetMapping 
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") String id) {
        return repo.findById(id).map(ResponseEntity::ok).orElseGet(() -> 
                ResponseEntity.notFound().build());
    }
}
