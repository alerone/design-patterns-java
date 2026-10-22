package shoplab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * EmailChannel
 */
@Component("sms")
public class SmsChannel implements NotificationChannel {

    private static final Logger log =
        LoggerFactory.getLogger(EmailChannel.class);

    @Override
    public void deliver(String recipient, String text) {
        log.info("[SMS to {}] {}", recipient, text);
    }
}
