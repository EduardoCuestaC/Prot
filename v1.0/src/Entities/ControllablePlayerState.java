package Entities;

import Events.KeySubject;
import Events.MouseSubject;
import Events.Subject;

public class ControllablePlayerState extends PlayerState {
    public ControllablePlayerState(Player player){
        this.player = player;
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == KeySubject.getInstance())
            System.out.println("jijiji");
        /*
        if(subject == MouseSubject.getInstance()){
            if(player.getBoundingBox().contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println("hola");
            if(player.getBorders()[0].contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println(0);
            if(player.getBorders()[1].contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println(1);
            if(player.getBorders()[2].contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println(2);
            if(player.getBorders()[3].contains(((MouseSubject) subject).getState()[0], ((MouseSubject) subject).getState()[1]))
                System.out.println(3);
        }
        */
    }

    @Override
    public void changeToControllable() {

    }

    @Override
    public void changeToUncontrollable() {
        player.setCurrent(player.getUncontrollable());
    }
}
