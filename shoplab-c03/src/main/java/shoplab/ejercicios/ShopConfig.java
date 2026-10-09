package shoplab.ejercicios;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ShopConfig
 */
@Configuration 
public class ShopConfig {


    @Bean 
    public ShopSettings settings(
            @Value("${shop.store-name}")String storeName,
            @Value("${shop.default-currency}")String defaultCurrency,
            @Value("${shop.max-items-per-order}")int maxItemsPerOrder
            ){
        return new ShopSettings(storeName, defaultCurrency, maxItemsPerOrder);
    }
    
}
