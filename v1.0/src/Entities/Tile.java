package Entities;

import Engine.Grid;

import java.awt.*;

public class Tile extends Enemy{

    public Tile(int x, int y, int w, int h)
    {
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        Grid.getInstance().add(this);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x,y,w,h);
    }
}
