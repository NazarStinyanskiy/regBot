package help;

import bot.Command;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import users.NormalState;
import users.User;

public class Help implements Command {

    @Override
    public SendMessage command(Message message, User user) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Вот ваша справка:\n" +
                "Чтобы получить справку введите: /help\n" +
                "Чтобы зарегистрироваться введите: /reg");

        user.setState(new NormalState());

        return sendMessage;
    }
}
