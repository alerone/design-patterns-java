package shoplab;

import java.util.Objects;

/**
 * Product
 */
public record Product(
        String id,
        String name,
        Money price,
        ProductKind kind,
        int stock,
        String category) {
    public Product {
        Objects.requireNonNull(price, "price");
        Objects.requireNonNull(kind, "kind");

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id must not be blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("category must not be blank");
        }
        if (stock < 0) {
            throw new IllegalArgumentException(
                    "stock must not be negative: " + stock);
        }
    }
}
