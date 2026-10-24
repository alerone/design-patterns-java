package shoplab;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * CheckoutFacade
 */
@RequiredArgsConstructor 
@Component 
public class CheckoutFacade {

    private final PaymentProcessorFactory processors;
    private final Map<String, NotificationChannel> channels;

    public CheckoutResult checkout(Order order, String channel) {
        NotificationChannel selected = channels.get(channel);

        if (selected == null) {
            throw new IllegalArgumentException("unknown channel " + channel);
        }

        Money amount = order.total();
        PaymentResult payment = processors
            .create(order.getPaymentType())
            .charge(amount);
        new PaymentConfirmation(selected, order, payment)
            .send(order.getShippingAddress().getRecipient());
        return new CheckoutResult(order.getId(), amount, payment);
    }
}
