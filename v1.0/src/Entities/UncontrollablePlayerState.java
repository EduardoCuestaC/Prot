package Entities;

import Events.Subject;

public class UncontrollablePlayerState extends PlayerState{
    public UncontrollablePlayerState(Player player){
        this.player = player;
    }
    @Override
    public void updateOnEvent(Subject subject) {

    }

    @Override
    public void changeToControllable() {
        player.setCurrent(player.getControllable());
    }

    @Override
    public void changeToUncontrollable() {

    }
}
