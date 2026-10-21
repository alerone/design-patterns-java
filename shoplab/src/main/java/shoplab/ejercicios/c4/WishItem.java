package shoplab.ejercicios.c4;

/**
 * WishItem
 */
public class WishItem {

    private final String name;
    private int quantity;

    public WishItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    private WishItem(WishItem other) {
        this.name = other.name;
        this.quantity = other.quantity;
    }

    public WishItem copy() {
        return new WishItem(this);
    }

    public String getName() { return this.name; }
    public int getQuantity() { return this.quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
