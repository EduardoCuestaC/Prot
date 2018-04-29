package Engine;

public class Jumper implements Runnable, Producer{
    private double dy;
    private double vi;
    private double fg = 0.5;
    private Buffer buff;
    private int i =0;
    private Thread t;

    public Jumper(Buffer buffer, int vi){
        this.vi = vi;
        buff = buffer;
        buff.clear();
    }

    @Override
    public void run()
    {
        while (true) {
            while (!buff.isFull()) {
                vi += fg;
                dy = vi;
                try {
                    buff.set((int)dy);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{
                    Thread.sleep(20);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void start() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void stop() {
        t.stop();

    }
}
