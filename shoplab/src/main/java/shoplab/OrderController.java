package shoplab;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * OrderController
 */
@RestController 
@RequiredArgsConstructor 
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;


    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody CreateOrderRequest rq) {
        return service.create(rq);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable String id) {
        return service.find(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/{id}/repeat")
    public ResponseEntity<Order> repeat(@PathVariable String id) {
        return service.repeat(id)
            .map(o -> ResponseEntity.status(HttpStatus.CREATED).body(o))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
