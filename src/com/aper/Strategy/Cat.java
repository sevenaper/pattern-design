package com.aper.Strategy;

public class Cat implements Comparable<Cat> {
    public int weight;

    @Override
    public int compareTo(Cat o) {
        Cat c = (Cat) o;
        if (this.weight < c.weight) return -1;
        else return 1;
    }

}
