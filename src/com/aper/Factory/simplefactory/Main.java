package com.aper.Factory.simplefactory;

public class Main {
    public static void main(String[] args) {
        Movable m = new CarFactory().createCar();
        m.go();
    }
}
