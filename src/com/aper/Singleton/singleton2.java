package com.aper.Singleton;

public class singleton2 {
    private static final singleton2 INSTANCE;

    static {
        INSTANCE = new singleton2();
    }

    private singleton2() {
    }

    public static singleton2 getInstance() {
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        singleton1 m1 = singleton1.getInstance();
        singleton1 m2 = singleton1.getInstance();
        System.out.println(m1 == m2);
    }
}

