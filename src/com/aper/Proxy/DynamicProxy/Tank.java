package com.aper.Proxy.DynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                (proxy, method, args1) -> {
                    System.out.println("method " + method.getName() + " start..");
                    Object o = method.invoke(tank, args1);
                    System.out.println("method " + method.getName() + " end..");
                    return o;
                });
        m.move();
    }
}

interface Movable {
    void move();
}
