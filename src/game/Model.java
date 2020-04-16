package game;

public class Model {

    private Level current;

    public Model(){
        current =Level.START;
    }

    public Memento save(){
        System.out.printf("Memento saved!");
        return new Memento(current);
    }

    public void restore(Memento m) {
        System.out.println("State restored!");
        current = m.getState();
    }

}
