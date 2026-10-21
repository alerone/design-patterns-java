package shoplab.ejercicios.c4;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Wishlist
 */
public class Wishlist {

    private final String id;
    private final String owner;
    private final List<WishItem> items = new ArrayList<>();

    public Wishlist(String id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    private Wishlist(Wishlist other) {
        this.id = UUID.randomUUID().toString();
        this.owner = other.owner;
        for (WishItem item : other.items) {
            this.items.add(item.copy());
        }
    }

    public Wishlist copy() {return new Wishlist(this);}

    public void add(WishItem item) {this.items.add(item);}
    public List<WishItem> getItems() { return items; }
    public String getId() { return id; }
    public String getOwner() { return owner; }
}
