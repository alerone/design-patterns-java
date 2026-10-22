package shoplab;

import lombok.RequiredArgsConstructor;

/**
 * Notification
 */
@RequiredArgsConstructor 
public abstract class Notification {
    protected final NotificationChannel channel;
    public abstract void send(String recipient);
}
