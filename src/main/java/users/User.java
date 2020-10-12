package users;

import bot.Command;

public class User {
    private final long id;
    private Command state;
    
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
}
