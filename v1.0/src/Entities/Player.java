package Entities;

import java.awt.*;

public class Player extends Entity {
    private Figure figure;


    public Player(){
        setX(200);
        setY(200);
        setW(40);
        setX(40);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        figure.render(g);
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}
