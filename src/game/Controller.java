package game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private Button levelup;

    private Model m;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        m = new Model();
    }

    public void refresh(){

    }

}
