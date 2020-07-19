package com.aper.Iterator;

public interface Collection {
    public void add(Object o);

    public int size();

    public Iterator iterator();
}

interface Iterator {
    public Object next();

    public boolean hasNext();
}