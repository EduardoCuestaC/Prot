package States;

import Game.GameContext;
import Sound.Track;
import TileMap.TileMap;

import java.awt.*;

public class PlayState extends GameState {
    private Track track =   new Track("dog", true);
    private boolean once = false;
    private String nivel;
    private TileMap tilemap = new TileMap("C:\\Users\\ALEXI\\IdeaProjects\\TileMap\\src\\TileMap\\nivel1.txt", 32);

    public PlayState(){
        nivel = "C:\\Users\\ALEXI\\IdeaProjects\\TileMap\\src\\TileMap\\nivel1.txt";
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
        tilemap.paint(g);

    }
}
