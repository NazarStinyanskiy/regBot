package bot;

import help.Help;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import reg.RegEnterPhone;
import reg.RegEnterPhoneError;
import reg.RegFinal;
import reg.RegStart;
import users.NormalState;
import users.User;

import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    private static final String botName = "MyPuperSuperTestBot";
    private static final String token = "925986929:AAG57828XZ-Q2uztEdtcd8GcCbnIeQzWvY8";
    private static final List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi tgBotApi = new TelegramBotsApi();
        try {
            tgBotApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    private boolean sendMessage(Message message, User user){
        try {
            execute(user.getState().command(message, user));
            return true;
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return false;
    }

    // написати тут метод write();
    // зробити для кожного стану реєстрації свій клас і реалізувати в них команд.

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        if (message == null || !message.hasText()) return;

        User currentUser = userSettings(message);

        sendMessage(message, currentUser);
    }

    private User userSettings(Message message){
        boolean newUser = false;
        User currentUser = null;

        for (User user : users) {
            if(user.getId() == message.getChatId()){
                newUser = true;
                currentUser = user;
                break;
            }
        }

        if(!newUser) {
            users.add(new User(message.getChatId()));
            currentUser = users.get(users.size() - 1);
        }

        currentUser.setCurrentMessage(message);

        if(currentUser.getState() instanceof RegFinal) currentUser.setState(new NormalState());

        if(currentUser.getState() instanceof RegEnterPhone || currentUser.getState() instanceof RegEnterPhoneError) {
            currentUser.setPhoneInfo();
            if (currentUser.writeData()) {
                currentUser.setState(new RegFinal());
            } else {
                currentUser.setState(new RegEnterPhoneError());
            }
        }

        if(currentUser.getState() instanceof RegStart) {
            currentUser.setState(new RegEnterPhone());
            currentUser.setNameInfo();
        }

        if(message.getText().equals("/help")) currentUser.setState(new Help());

        if(message.getText().equals("/reg")) currentUser.setState(new RegStart());

        System.out.println(currentUser.getState());

        return currentUser;
    }

    public String getBotUsername() {
        return botName;
    }

    public String getBotToken() {
        return token;
    }
}