package Sound;

import javax.sound.sampled.Clip;

public class Track implements Runnable{
    private Clip c;

    public Track(String name){
        c = SoundLoader.getInstance().getClip(name);
    }

    public void play(){
        (new Thread(this)).start();
    }

    @Override
    public void run() {
        if(c.isRunning()){
            c.stop();
            c.setFramePosition(0);
        }
        c.start();
    }
}
