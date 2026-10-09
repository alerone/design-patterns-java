package shoplab.ejercicios;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ShopRegistry
 */
public final class ShopRegistry {
    private final Set<String> storeIds = ConcurrentHashMap.newKeySet();

    private ShopRegistry() {}

    private static final class Holder {
        private static final ShopRegistry INSTANCE = new ShopRegistry();
    }

    public static ShopRegistry getInstance() {return Holder.INSTANCE;}

    public boolean register(String storeId) {
        return storeIds.add(storeId);
    }

    public int count() {
        return storeIds.size();
    }
}
