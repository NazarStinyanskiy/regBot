package start;

import bot.Command;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import users.User;

public class Start implements Command {
    @Override
    public SendMessage command(Message message, User user) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Здравствуйте, чтобы получить справку по боту, напишите /help");

        return sendMessage;
    }
}
