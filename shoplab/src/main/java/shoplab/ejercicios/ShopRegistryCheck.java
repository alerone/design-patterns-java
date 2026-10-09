package shoplab.ejercicios;

/**
 * ShopRegistryCheck
 */
public class ShopRegistryCheck {

    public static void main(String[] args) {
        ShopRegistry first = ShopRegistry.getInstance();
        ShopRegistry second = ShopRegistry.getInstance();
        System.out.println(first == second);
        System.out.println(first.register("madrid"));
        System.out.println(second.register("madrid"));
        System.out.println(second.register("lisboa"));
        System.out.println(first.count());
    }
}
