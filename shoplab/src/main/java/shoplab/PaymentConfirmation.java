package shoplab;

/**
 * PaymentConfirmation
 */
public class PaymentConfirmation extends Notification{

    private final Order order;
    private final PaymentResult result;

    public PaymentConfirmation(NotificationChannel channel,
            Order order, PaymentResult result) {
        super(channel);
        this.order = order;
        this.result = result;
    }

    @Override
    public void send(String recipient) {
        channel.deliver(recipient, "Order " + order.getId() + ": " 
                + result.message() + " (" + result.transactionId() + ")");
    }

    
}
