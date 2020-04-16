package game;

/**
 * Stores a State that can be restored
 */
public class Memento {

    private Level state;

    /**
     * initializes the memento by setting the state
     * @param state
     */
    public Memento(Level state) {
        this.state = state;
    }

    /**
     * returns the state
     * @return
     */
    public Level getState(){
        return state;
    }
}
