package shoplab.ejercicios.c5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MailChannel
 */
public class MailChannel implements Channel {
    private static Logger log = 
        LoggerFactory.getLogger(MailChannel.class);

    @Override
    public void deliver(String to, String text) {
        log.info("mail to {}: {}", to, text);
    }
}
