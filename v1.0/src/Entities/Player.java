package Entities;

import Engine.Buffer;
import Engine.Grid;
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
    private Buffer buffer = new Buffer();

    public Buffer getBuffer() {
        return buffer;
    }

    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }



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
        KeySubject.getInstance().subscribe(this);
        current = controllable;
        Grid.getInstance().add(this);
    }

    @Override
    public void setX(int x){
        this.x = x;
        boundingBox.setBounds(this.x, y, w, h);
        updateBorders();
        figure.setX(this.x);
    }

    @Override
    public void setY(int y) {
        this.y = y;
        boundingBox.setBounds(x, this.y, w, h);
        updateBorders();
        figure.setY(this.y);
    }

    @Override
    public void setW(int w) {
        this.w = w;
        boundingBox.setBounds(x, y, this.w, h);
        updateBorders();
        figure.setW(this.w);
    }

    @Override
    public void setH(int h) {
        this.h = h;
        boundingBox.setBounds(x, y, w, this.h);
        updateBorders();
        figure.setH(this.h);
    }

    @Override
    public void update() {
        Grid.getInstance().checkCollisions(this);
        int a;
        try {
            if(!buffer.isEmpty()) {
                a = buffer.get();
                setY(getY() + a);
                System.out.println(a);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

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
        System.out.println("type is: "+type);
    }

    public void changeToControllable(){
        current.changeToControllable();
    }

    public void changeToUncontrollable(){
        current.changeToUncontrollable();
    }
}
