package com.aper.factory.simplefactory;

public class CarFactory {
    public Movable createCar(){
        System.out.println("a car created");
        return new Car();
    }
}
