package game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class Controller {

    @FXML
    private Button levelup;

    private int lvl;



    public Memento save(){
        System.out.printf("Memento saved!");
        return new Memento(lvl);
    }

    public void restore(Memento m) {
        System.out.println("State restored!");
        lvl = m.getState();
    }


}
