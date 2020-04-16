package game;

import editor.Caretaker;
import editor.Controller;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Handler implements EventHandler<KeyEvent> {

    private editor.Controller controller;
    private editor.Caretaker caretaker;

    public Handler(Controller controller, Caretaker caretaker){
        this.caretaker=caretaker;
        this.controller=controller;
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println("typed");
        switch (event.getCode()){
            case S:
                if(event.isControlDown()){
                    controller.save();
                }
                break;
            case B:
            if(event.isControlDown()){
                controller.restore(caretaker.getState(false));
            }
            break;

        }
    }
}
