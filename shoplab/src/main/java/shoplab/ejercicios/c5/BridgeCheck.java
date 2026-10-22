package shoplab.ejercicios.c5;
/**
 * BridgeCheck
 */
public class BridgeCheck {

    public static void main(String[] args) {
        Channel email = new MailChannel();
        Channel sms = new TextChannel();
        Channel put = new PutChannel();

        Message message1 = new WelcomeMessage(email);
        Message message2 = new WelcomeMessage(sms);
        Message message3 = new ReminderMessage(email);
        Message message4 = new ReminderMessage(sms);
        Message message5 = new WelcomeMessage(put);

        message1.send("carlos");
        message2.send("carlos");
        message3.send("carlos");
        message4.send("carlos");
        message5.send("carlos");
    }
}
