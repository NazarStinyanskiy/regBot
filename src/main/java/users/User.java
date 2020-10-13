package users;

import bot.Command;
import org.telegram.telegrambots.meta.api.objects.Message;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

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

    public void setNameInfo() {
        this.nameInfo = currentMessage.getText();
    }

    public void setPhoneInfo() {
        this.phoneInfo = currentMessage.getText();
    }

    public void writeData(){
        try(Writer writer = new FileWriter("src/main/resources/data.txt", true)) {
            writer.append("Name: ").append(nameInfo).append(", ").append("Phone: ").append(phoneInfo).append(";\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentMessage(Message currentMessage) {
        this.currentMessage = currentMessage;
    }
}
