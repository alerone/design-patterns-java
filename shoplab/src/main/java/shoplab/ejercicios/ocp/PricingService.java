package shoplab.ejercicios.ocp;

import java.math.BigDecimal;

import shoplab.Money;

public class PricingService {
    public PricingService() {}
    public Money finalPrice(CustomerDiscount discount, Money base) {
        return base.minus(base.times(discount.rate()));
    }

    public static void main(String[] args) {
        PremiumDiscount premium = new PremiumDiscount();
        RegularDiscount regular = new RegularDiscount();
        VipDiscount vip = new VipDiscount();
        StudentDiscount student = new StudentDiscount();
        
        PricingService service = new PricingService();
        Money BASE = new Money(BigDecimal.valueOf(100), "EUR");

        System.out.println(service.finalPrice(regular, BASE));
        System.out.println(service.finalPrice(premium, BASE));
        System.out.println(service.finalPrice(vip, BASE));
        System.out.println(service.finalPrice(student, BASE));
    }
}
