package game;

/**
 * Takes the originator role int the context of the memento pattern
 * stores all of the games information
 */
public class Model {

    private Level current;

    /**
     * initializes the model by setting the initial level to start
     */
    public Model(){
        current = Level.START;
    }

    /**
     * Returns a new memento containing the games current state
     * @return
     */
    public Memento save(){
        System.out.printf("Memento saved!");
        return new Memento(current);
    }

    /**
     * Setting the games current state to the one contained in the passed memento
     * @param m
     */
    public void restore(Memento m) {
        System.out.println("State restored!");
        current = m.getState();
    }

    /**
     * Sets the new level depending on the current one when pressing button op1
     */
    public void op1(){
        switch (current){
            case POND:
            case START:
                current = Level.FOREST;
                break;
            case FOREST:
                current = Level.DARKPATH;
                break;
            case DARKPATH:
            case CAVE:
                current = Level.CAVELEFT;
                break;
            case CAVERIGHT:
            case CAVELEFT:
            case DEATH:
                current = Level.START;
                break;
        }
    }

    /**
     * Sets the new level depending on the current one when pressing button op2
     */
    public void op2(){
        switch (current){
            case START:
                current = Level.CAVE;
                break;
            case FOREST:
                current = Level.POND;
                break;
            case POND:
                current = Level.DEATH;
                break;
            case DARKPATH:
            case CAVE:
                current = Level.CAVERIGHT;
                break;
            case CAVELEFT:
            case CAVERIGHT:
            case DEATH:
                current = Level.START;
                break;
        }
    }

    /**
     * Returns the Text for the information Textfield and the buttons, depending on the current state
     * @return
     */
    public String[] getInfo(){
        String[] info = new String[3];
        switch (current){
            case START:
                info[0]="You're on a hike and have to choose between going into the forest or a cave.";
                info[1]="Forest";
                info[2]="Cave";
                break;
            case FOREST:
                info[0]="Inside of the forest you see a dark path to your left and a pond to your right.";
                info[1]="Dark path";
                info[2]="Pond";
                break;
            case CAVE:
                info[0]="A few steps into the cave the path splits into two.";
                info[1]="Left";
                info[2]="Right";
                break;
            case DARKPATH:
                info[0]="You reach a Cave and Walk inside, in front of you the path splits.";
                info[1]="Left";
                info[2]="Right";
                break;
            case POND:
                info[0]="You have reached a pond, \nthere isnt much to do except for jumping into the water or going back.";
                info[1]="Go back";
                info[2]="Swim";
                break;
            case CAVELEFT:
                info[0]="You are greeted by a hungry grizzly.\nYou are dead.";
                info[1]="Reset";
                info[2]="Reset";
                break;
            case CAVERIGHT:
                info[0]="You find a treasure chest filled with gold.\nYou have won!";
                info[1]="Reset";
                info[2]="Reset";
                break;
            case DEATH:
                info[0]="The water is filled with Piranhas, thank you for filling their bellies.\nYou are dead.";
                info[1]="Reset";
                info[2]="Reset";
                break;
        }
        return info;
    }
}
