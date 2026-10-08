package shoplab;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ProductKind
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProductKind.Physical.class, name = "physical"),
        @JsonSubTypes.Type(value = ProductKind.Digital.class, name = "digital"),
        @JsonSubTypes.Type(value = ProductKind.Service.class, name = "service")
})
public sealed interface ProductKind
        permits ProductKind.Physical, ProductKind.Digital, ProductKind.Service {

    public record Physical(int weightGrams) implements ProductKind {
    }

    public record Digital() implements ProductKind {
    }

    public record Service(int durationMinutes) implements ProductKind {
    }
}
