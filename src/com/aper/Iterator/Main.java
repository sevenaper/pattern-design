package com.aper.Iterator;

public class Main {
    public static void main(String[] args) {
        //Collection c=new ArrayList();
        Collection c = new LinkedList();
        for (int i = 0; i < 15; i++) {
            c.add(i);
        }
        System.out.println(c.size());

        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            System.out.println(((Node) iter.next()).getData());
        }
    }
}
