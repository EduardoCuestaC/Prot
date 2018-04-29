package Entities;

import Events.Subject;

public abstract class PlayerState {
    protected Player player;
    public abstract void updateOnEvent(Subject subject);
    public abstract void changeToControllable();
    public abstract void changeToUncontrollable();
}
