package shoplab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * PaymentConfig
 */
@Configuration 
public class PaymentConfig {


    @Bean("card")
    PaymentProcessor cardProcessor(
            @Value("${shop.gateway}") String gateway,
            LegacyCardClient legacy,
            FastPayClient fastPay) {
        return switch (gateway) {
            case "legacy" -> new LegacyCardAdapter(legacy);
            case "fastpay" -> new FastPayAdapter(fastPay);
            default -> throw new IllegalStateException(
                    "unknown shop.gateway: " + gateway);
        };
    }
}
