package users;

import bot.Command;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class NormalState implements Command {

    @Override
    public SendMessage command(Message message, User user) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Не понимаю.");

        user.setState(new NormalState());

        return sendMessage;
    }
}
