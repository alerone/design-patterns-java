package shoplab.ejercicios.c5;

/**
 * ReminderMessage
 */
public class ReminderMessage extends Message{

    protected ReminderMessage(Channel channel) {
        super(channel);
    }

    @Override
    public void send(String to) {
        channel.deliver(to, "reminder");
    }
}
