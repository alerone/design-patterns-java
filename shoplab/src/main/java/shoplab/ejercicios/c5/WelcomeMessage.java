package shoplab.ejercicios.c5;

/**
 * WelcomeMessage
 */
public class WelcomeMessage extends Message{

    protected WelcomeMessage(Channel channel) {
        super(channel);
    }

    @Override
    public void send(String to) {
        channel.deliver(to, "welcome");
    }
}
