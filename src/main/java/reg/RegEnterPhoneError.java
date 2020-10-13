package reg;

import bot.Command;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import users.User;

public class RegEnterPhoneError implements Command {

    @Override
    public SendMessage command(Message message, User user) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Проверьте правильность ввода телефона.\nВведите номер телефона:");

        return sendMessage;
    }
}
