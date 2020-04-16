package game;

public class Memento {

    private Level state;

    public Memento(Level state) {
        this.state = state;
    }

    public Level getState(){
        return state;
    }
}
