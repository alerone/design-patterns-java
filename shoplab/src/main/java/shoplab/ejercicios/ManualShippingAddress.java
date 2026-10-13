package shoplab.ejercicios;

import java.util.List;

/**
 * ManualShippingAddress
 */
public class ManualShippingAddress {
    String recipient;
    String street;
    String city;
    String postalCode;
    String country;
    List<String> deliveryNotes;

    public ManualShippingAddress(ManualShippingAddress.Builder b) {
        this.recipient = b.recipient;
        this.street = b.street;
        this.city = b.city;
        this.postalCode = b.postalCode;
        this.country = b.country;
        this.deliveryNotes = b.deliveryNotes;
    }

    public Builder builder() { return new Builder(); }

    public String getCountry() { return this.country; }
    public List<String> getDeliveryNotes() { return this.deliveryNotes; }
    public String getCity() { return this.city; }

    public static class Builder {
        private String recipient;
        private String street;
        private String city;
        private String postalCode;
        private String country = "ES";
        private List<String> deliveryNotes;

        public Builder recipient(String value) {
            this.recipient = value;
            return this;
        }

        public Builder street(String value) {
            this.street = value;
            return this;
        }

        public Builder postalCode(String value) {
            this.postalCode = value;
            return this;
        }

        public Builder country(String value) {
            this.country = value;
            return this;
        }

        public Builder deliveryNote(String note) {
            this.deliveryNotes.add(note);
            return this;
        }

        public Builder deliveryNotes(List<String> value) {
            this.deliveryNotes = List.copyOf(value);
            return this;
        }

        public ManualShippingAddress build() {
            require(recipient, "recipient");
            require(street, "street");
            require(city, "city");
            require(country, "country");

            return new ManualShippingAddress(this);
        }

        private static void require(String value, String field) {
            if (value == null || value.isBlank()) {
                throw new IllegalArgumentException(field + " is required");
            }
        }
    }

}
