package shoplab.ejercicios.c4;

/**
 * ProfileCheck
 */
public class ProfileCheck {

    public static void main(String[] args) {
        CustomerProfile p = CustomerProfile.builder()
            .name("Carlos").email("a@b.c").tag("vip").tag("other").build();
        System.out.println(p.getPlan() + " " + p.getTags());
        try {
            CustomerProfile.builder().name("Carles").build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
