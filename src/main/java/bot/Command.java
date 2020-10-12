package bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import users.User;

public interface Command {
    SendMessage command(Message message, User user);
}
