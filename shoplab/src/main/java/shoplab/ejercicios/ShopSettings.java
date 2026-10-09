package shoplab.ejercicios;

import java.util.Objects;

/**
 * ShopSettings
 */
public record ShopSettings(String storeName, String defaultCurrency, int maxItemsPerOrder) {
    public ShopSettings {
        Objects.requireNonNull(maxItemsPerOrder);
        if (storeName == null || storeName.isBlank()) throw new IllegalArgumentException("store must have a name");
        if (defaultCurrency == null || defaultCurrency.isBlank()) throw new IllegalArgumentException("there must be a default currency");

        if (maxItemsPerOrder < 0) throw new IllegalArgumentException("max items per order must be positive");
    }
}
