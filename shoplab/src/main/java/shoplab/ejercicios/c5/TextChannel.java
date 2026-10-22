package shoplab.ejercicios.c5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TextChannel
 */
public class TextChannel implements Channel {
    private static Logger log = 
        LoggerFactory.getLogger(TextChannel.class);

    @Override
    public void deliver(String to, String text) {
        log.info("sms to {}: {}", to, text);
    }
}
