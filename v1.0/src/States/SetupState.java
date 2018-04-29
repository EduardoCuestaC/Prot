package States;

import Entities.Player;
import Entities.Rect;
import Events.Counter;
import Game.GameContext;
import Sound.Track;

import java.awt.*;

public class SetupState extends GameState {
    private Track track =   new Track("dog");
    private boolean once = false;
    private Player player;

    public SetupState(){
        player = new Player();
        player.setFigure(new Rect(player.getX(), player.getY(), player.getW(), player.getH()));
    }

    @Override
    public void changeToRunning() {

    }

    @Override
    public void stopGame() {

    }

    @Override
    public void changeToTurn1() {

    }

    @Override
    public void changeToTurn2() {
    }

    @Override
    public void gameUpdate() {
    }

    @Override
    public void setGameContext(GameContext context){

    }

    @Override
    public void gameRender(Graphics g) {
        if(!once){
            track.play();
            once = true;
        }
        g.setColor(Color.black);
        player.render(g);
    }
}
