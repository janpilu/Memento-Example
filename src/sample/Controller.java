package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class Controller {

    @FXML
    private TextArea textarea;

    public Memento save(){
        System.out.printf("Memento saved!");
        return new Memento(textarea.getText());
    }

    public void restore(Memento m) {
        textarea.setText(m.getState());
        System.out.println("State restored!");
    }


}
