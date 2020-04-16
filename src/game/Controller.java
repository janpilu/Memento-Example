package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The Controller acts as the Caretaker in the Context of the Memento Pattern
 * It stores the Mementos in the Combobox, and it can save and restore Mementos by
 * saving the Models current state into the Combobox or passing the selected value into the Models
 * restore function
 */
public class Controller implements Initializable {

    @FXML
    private Button op1;

    @FXML
    private Button op2;

    @FXML
    private Text info;

    @FXML
    private ComboBox<Memento> states;

    @FXML
    private Button load;

    private Model m;

    /**
     * Called before the Frame is displayed
     * initializes model and calls refresh to set the stage for the game.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        m = new Model();
        refresh();
    }

    /**
     * Gets the current information from the Model
     * and Pastes it into the UI
     */
    public void refresh(){
        this.info.setText(m.getInfo()[0]);
        this.op1.setText(m.getInfo()[1]);
        this.op2.setText(m.getInfo()[2]);
        if(states.getSelectionModel().isEmpty())
            load.setDisable(true);
        else
            load.setDisable(false);
    }

    /**
     * Stores the current state into a Memento using the models save Method
     * the created memento is the stored into the Combobox
     */
    public void save(){
        Memento state =m.save();
        states.getItems().addAll(state);
    }

    /**
     * Calls the Models restore function, passing the selected memento as the parameter
     */
    public void reload(){
        m.restore(states.getValue());
        refresh();
    }

    /**
     * Called by pressing the left button
     * calls the models op1 function
     * and refreshs the ui afterwards
     * @param actionEvent
     */
    public void op1(ActionEvent actionEvent) {
        m.op1();
        refresh();
    }

    /**
     * Called by pressing the right button
     * calls the models op2 function
     * and refreshs the ui afterwards
     * @param actionEvent
     */
    public void op2(ActionEvent actionEvent) {
        m.op2();
        refresh();
    }

}
