package reg;

import bot.Command;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import users.NormalState;
import users.User;

public class RegFinal implements Command {
    @Override
    public SendMessage command(Message message, User user) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Вы успешно зарегистрировались!");

        return sendMessage;
    }
}
