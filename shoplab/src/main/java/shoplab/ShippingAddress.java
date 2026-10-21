package shoplab;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/**
 * ShippingAddress
 */
@Value 
@Builder  
@Jacksonized 
public class ShippingAddress {

    String recipient;
    String street;
    String city;
    String postalCode;
    @Builder.Default String country = "ES";
    @Singular("deliveryNote") List<String> deliveryNotes;


    public ShippingAddress(String recipient, String street, String city,
            String postalCode, String country, List<String> deliveryNotes) {
        requireText(recipient, "recipient");
        requireText(street, "street");
        requireText(city, "city");
        requireText(country, "country");

        this.recipient = recipient;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.deliveryNotes = List.copyOf(deliveryNotes);
    }

    private static void requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " is required");
        }
    }

    
}
