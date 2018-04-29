package Entities;

import Engine.RigidBody;
import Events.*;


import java.awt.*;

public class Player extends Entity implements Observer, RigidBody {
    private Figure figure;
    private Rectangle[] borders = {new Rectangle(x+w, y, 1, h),
                                    new Rectangle(x, y-1, w, 1),
                                    new Rectangle(x-1, y,1, h),
                                    new Rectangle(x, y+h, w, 1)};

    private PlayerState controllable = new ControllablePlayerState(this);
    private PlayerState uncontrollable = new UncontrollablePlayerState(this);
    private PlayerState current;


    public PlayerState getControllable() {
        return controllable;
    }

    public PlayerState getUncontrollable() {
        return uncontrollable;
    }

    public void setCurrent(PlayerState state){
        current = state;
    }



    public Player(){
        setX(200);
        setY(200);
        setW(40);
        setH(40);
        KeySubject.getInstance().subscribe(this);
        current = controllable;
    }

    @Override
    public void update() {

    }

    @Override
    public void updateBorders(){
        borders[0].setBounds(x+w, y, 1, h);
        borders[1].setBounds(x, y-1, w, 1);
        borders[2].setBounds(x-1, y,1, h);
        borders[3].setBounds(x, y+h, w, 1);
    }

    public Rectangle[] getBorders(){
        return borders;
    }

    @Override
    public void render(Graphics g) {
        figure.render(g);
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void updateOnEvent(Subject subject) {
        current.updateOnEvent(subject);
    }

    @Override
    public void react(int type) {

    }

    public void changeToControllable(){
        current.changeToControllable();
    }

    public void changeToUncontrollable(){
        current.changeToUncontrollable();
    }
}
