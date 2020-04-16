package editor;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Handler implements EventHandler<KeyEvent> {

    private Controller controller;
    private Caretaker caretaker;

    public Handler(Controller controller, Caretaker caretaker){
        this.caretaker=caretaker;
        this.controller=controller;
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println("typed");
        switch (event.getCode()){
            case SPACE:
                //if(event.isControlDown())
                    caretaker.save(controller.save());
                break;
            case R:
                if(event.isControlDown()){
                    controller.restore(caretaker.getState(true));
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
