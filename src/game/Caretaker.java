package game;

import editor.Memento;

import java.util.ArrayList;

public class Caretaker {

    private ArrayList<editor.Memento> states;
    private int currentState;

    public Caretaker(){
        this.states=new ArrayList<>();
        this.states.add(new editor.Memento(""));
        this.currentState = 1;
    }

    public void save(editor.Memento m){
        states.add(m);
        currentState=states.size()-1;
    }

    public Memento getState(boolean old){
        if(old) {
            if (currentState == 0)
                return states.get(currentState);
            return states.get(currentState--);
        }else
        if (currentState == states.size())
            return states.get(states.size()-1);
        return states.get(currentState++);
    }
}
