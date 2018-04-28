package Game;

import Events.Counter;
import Events.Observer;
import Events.Subject;

public class ContextObserver implements Observer {

    private GameContext context;
    private int transitions;

    public ContextObserver(GameContext context){
        this.context = context;
        Counter.getInstance().subscribe(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == Counter.getInstance()){
            if(context.getCurrent() == context.getSetup()) {
                context.changeToTurn1();
            }
        }
    }
}
