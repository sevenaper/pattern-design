package com.aper.Proxy.StaticProxy;

import java.util.Random;

public class TankTimeProxy implements Movable {
    Movable movable;

    public void bind(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        new TankTimeProxy().move();
    }
}

interface Movable {
    void move();
}

class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
