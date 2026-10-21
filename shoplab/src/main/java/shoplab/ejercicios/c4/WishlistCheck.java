package shoplab.ejercicios.c4;

/**
 * WishlistCheck
 */
public class WishlistCheck {

    public static void main(String[] args) {
        Wishlist a = new Wishlist("a", "Lucía");
        a.add(new WishItem("monitor", 1));
        Wishlist b = a.copy();
        b.getItems().get(0).setQuantity(2);
        b.add(new WishItem("raton", 2));

        System.out.println(a.getItems().size() + " "
            + a.getItems().get(0).getQuantity());
        System.out.println(b.getItems().size() + " "
            + b.getItems().get(0).getQuantity());
        System.out.println(a.getId().equals(b.getId())); // false
    }
}
