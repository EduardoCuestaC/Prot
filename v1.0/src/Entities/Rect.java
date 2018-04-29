package Entities;

import java.awt.*;

public class Rect extends Figure{

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawRect(x, y, w, h);
    }
}
