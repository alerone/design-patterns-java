package shoplab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.With;

/**
 * Order
 */
@Value
@Builder(toBuilder = true)
public class Order {

    @With String id;
    @Singular("line") List<OrderLine> lines;
    ShippingAddress shippingAddress;
    String region;
    PaymentType paymentType;

    public Order(String id, List<OrderLine> lines,
            ShippingAddress shippingAddress, String region,
            PaymentType paymentType) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("id is required");
        if (lines == null || lines.isEmpty())
            throw new IllegalArgumentException("an order needs lines");
        if (shippingAddress == null)
            throw new IllegalArgumentException("shipping address is required");
        if (region == null || region.isBlank())
            throw new IllegalArgumentException("region is required");
        if (paymentType == null) 
            throw new IllegalArgumentException("paymentType is required");

        this.id = id;
        this.lines = List.copyOf(lines);
        this.shippingAddress = shippingAddress;
        this.region = region;
        this.paymentType = paymentType;
    }

    @JsonProperty("total")
    public Money total() {
        Money sum = Money.zero(lines.get(0).unitPrice().currency());
        for (OrderLine line : lines) {
            sum = sum.plus(line.subtotal());
        }
        return sum;
    }
}
