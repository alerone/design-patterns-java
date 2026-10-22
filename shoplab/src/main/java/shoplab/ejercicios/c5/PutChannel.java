package shoplab.ejercicios.c5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PutChannel
 */
public class PutChannel implements Channel {

    private static final Logger log =
        LoggerFactory.getLogger(PutChannel.class);

    @Override
    public void deliver(String to, String text) {
        log.info("put to {}: {}", to, text);
    }
}
