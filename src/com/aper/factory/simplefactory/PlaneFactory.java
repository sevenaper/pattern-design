package com.aper.factory.simplefactory;

public class PlaneFactory {
    public Movable createPlane() {
        System.out.println("a plane created");
        return new Plane();
    }
}
