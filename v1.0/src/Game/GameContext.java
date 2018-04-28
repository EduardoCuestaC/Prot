package Game;
import States.GameState;
import States.StateFactory;

import java.awt.*;
import java.util.ArrayList;

public class GameContext{
    private GameState stopped;
    private GameState setup;

    private GameState current;

    public void stopGame(){
        current.stopGame();
    }

    public void changeToTurn1(){
        current.changeToTurn1();
    }

    public void changeToTurn2(){
        current.changeToTurn2();
    }

    public void gameUpdate(){
        current.gameUpdate();
    }
    public void gameRender(Graphics g){
        current.gameRender(g);
    }

    public void setCurrent(GameState state){
        current = state;
    }
    public GameState getCurrent(){
        return current;
    }

    public GameState getSetup(){
        return setup;
    }
    public GameState getStopped() {
        return stopped;
    }

    public GameContext(){
        stopped = StateFactory.getInstance().createState("stopped");
        setup = StateFactory.getInstance().createState("setup");
        stopped.setGameContext(this);
        setup.setGameContext(this);

        current = setup;
    }

}
