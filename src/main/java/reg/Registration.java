//package reg;
//
//import bot.Command;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Message;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//
//public class Registration implements Command{
//    private static RegState state = RegState.START;
//
//    public static SendMessage command(Message message) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(message.getChatId());
//        sendMessage.setText("Чтобы зарегистрироваться, введите пожалуйста некоторую информацию.\nВведите имя:");
//        state = RegState.ENTER_PHONE;
//
//        return sendMessage;
//    }
//
//    public static SendMessage enterPhone(Message message){
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(message.getChatId());
//        sendMessage.setText("Введите номер телефона:");
//        state = RegState.FINAL;
//
//        return sendMessage;
//    }
//
//    public static SendMessage finalReg(Message message){
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(message.getChatId());
//        sendMessage.setText("Вы успешно зарегистрировались!");
//        state = RegState.START;
//
//        return sendMessage;
//    }
//
//    public static RegState getState() {
//        return state;
//    }
//
//    public static boolean writeInfo(String info){
//        try {
//            Writer writer = new FileWriter("../../resources/data.txt");
//            writer.append(info).append(";\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//}