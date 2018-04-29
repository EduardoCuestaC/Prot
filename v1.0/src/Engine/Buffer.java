package Engine;

import java.awt.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Buffer {
    private ArrayBlockingQueue<Point> b =  new ArrayBlockingQueue<Point>(5);

    public Point get() throws InterruptedException{
        return b.take();
    }

    public void set(Point p) throws InterruptedException{
        b.put(p);
    }
}
