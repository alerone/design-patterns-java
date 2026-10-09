package shoplab.ejercicios;

import java.math.BigDecimal;

import shoplab.Money;
import shoplab.ProductKind;

/**
 * ShippingCost
 */
public final class ShippingCost {
    /**
    * un físico de más de 5000 gramos cuesta
    * 9,90 EUR; cualquier otro físico, 4,90 EUR; un digital o un servicio, 0 EUR. Usa
    * un switch sin default y sin _.
    **/
    private static final String EUR = "EUR";
    public static Money shippingCost(ProductKind kind) {
        return switch(kind) {
            case ProductKind.Physical(int weighGrams) when weighGrams >= 5000 
                -> new Money(new BigDecimal("9.90"), EUR);
            case ProductKind.Physical(int weighGrams) -> new Money(new BigDecimal("4.90"), EUR);
            case ProductKind.Digital() -> Money.zero(EUR);
            case ProductKind.Service(int durationMinutes) -> Money.zero(EUR);
        };
    }

    public static void main(String[] args) {
        ProductKind.Physical p1 = new ProductKind.Physical(4800);      
        ProductKind.Physical p2 = new ProductKind.Physical(6969);      
        ProductKind.Digital d1 = new ProductKind.Digital();
        ProductKind.Service s1 = new ProductKind.Service(300);

        System.out.println(shippingCost(p1));
        System.out.println(shippingCost(p2));
        System.out.println(shippingCost(d1));
        System.out.println(shippingCost(s1));
    }
}
