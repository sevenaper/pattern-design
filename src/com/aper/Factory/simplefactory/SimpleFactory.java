package com.aper.Factory.simplefactory;

/**
 * 简单工厂可扩展性不好
 */
public class SimpleFactory {
    public static Movable createVehicle(int type) {
        if (type == 1) {
            return new CarFactory().createCar();
        } else if (type == 2) {
            return new PlaneFactory().createPlane();
        } else {
            return null;
        }
    }
}
