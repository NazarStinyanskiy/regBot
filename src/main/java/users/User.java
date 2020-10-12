package users;

import bot.Command;
import org.telegram.telegrambots.meta.api.objects.Message;
import reg.RegEnterPhone;
import reg.RegFinal;
import reg.RegStart;

public class User {
    private final long id;
    private Command state;
    private Message currentMessage;
    private String nameInfo;
    private String phoneInfo;

    public User(long id){
        state = new NormalState();
        this.id = id;
    }

    public Command getState() {
        return state;
    }

    public void setState(Command state) {
        this.state = state;

    }

    public long getId() {
        return id;
    }

    private void setNameInfo() {
        this.nameInfo = currentMessage.getText();
        System.out.println(nameInfo);
    }

    private void setPhoneInfo() {
        this.phoneInfo = currentMessage.getText();
        System.out.println(phoneInfo);
    }

    public void setCurrentMessage(Message currentMessage) {
        this.currentMessage = currentMessage;
    }
}
