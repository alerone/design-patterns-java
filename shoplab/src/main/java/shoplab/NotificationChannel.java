package shoplab;

/**
 * NotificationChannel
 */
public interface NotificationChannel {

    void deliver(String recipient, String text);
}
