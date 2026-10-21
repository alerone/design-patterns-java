package shoplab.ejercicios.c4;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

/**
 * CustomerProfile
 */
@Value 
@Builder 
public class CustomerProfile {

    String name;
    String email;
    String phone;
    @Builder.Default String plan = "free";
    @Singular List<String> tags;

    public CustomerProfile(String name, String email, String phone,
            String plan, List<String> tags) {
        if (name == null || name.isBlank()) 
            throw new IllegalArgumentException("name can't be null");
        if (email == null || email.isBlank()) 
            throw new IllegalArgumentException("email can't be null");

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.plan = plan;
        this.tags = List.copyOf(tags);
    }

    
}
