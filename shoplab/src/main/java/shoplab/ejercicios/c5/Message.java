package shoplab.ejercicios.c5;

/**
 * Message
 */
public abstract class Message {
    protected final Channel channel;

    protected Message(Channel channel) {this.channel = channel;}

    public abstract void send(String to);
}
