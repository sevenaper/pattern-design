package com.aper.Observer;

import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void actionOnWakeUp(wakeUpEvent event);
}

class Dad implements Observer {
    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        feed();
    }

    public void feed() {
        System.out.println("Dad feeding...");
    }
}

class Mom implements Observer {

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        hug();
    }

    public void hug() {
        System.out.println("Mom hugging...");
    }
}

class Child {
    private boolean isCrying = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
    }

    public boolean isCrying() {
        return isCrying;
    }

    public void wakeUp() {
        isCrying = true;
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");
        for (Observer o : observers) {
            o.actionOnWakeUp(event);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

//事件类，一般情况下需要知道来源
class wakeUpEvent extends Event<Child> {
    long timeStamp;
    String loc;
    Child source;

    public wakeUpEvent(long timeStamp, String loc) {
        this.timeStamp = timeStamp;
        this.loc = loc;
    }

    @Override
    public Child getSource() {
        return this.source;
    }
}