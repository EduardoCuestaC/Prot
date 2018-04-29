package States;

import Engine.Grid;
import Entities.Player;
import Entities.Rect;
import Entities.Tile;
import Events.Counter;
import Game.GameContext;
import Sound.Track;

import java.awt.*;

public class SetupState extends GameState {
    private Track track =   new Track("dog");
    private boolean once = false;
    private Player player;
    private Tile tile = new Tile(200, 240, 80, 10 );

    public SetupState(){
        player = new Player();
        player.setFigure(new Rect(player.getX(), player.getY(), player.getW(), player.getH()));
        player.setX(200);
        player.setY(200);
        player.setW(40);
        player.setH(40);
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
        player.update();
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
        tile.render(g);
    }
}
