package com.aper.Iterator;

class Node {

    private Object data;
    private Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}


public class LinkedList implements Collection {

    Node head = null;
    Node tail = null;
    int size = 0;

    @Override
    public void add(Object o) {
        Node n = new Node(o, null);
        if (head == null) {
            head = n;
            tail = n;
            size = 1;
            return;
        }
        tail.setNext(n);
        tail = n;
        size++;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    @Override
    public int size() {
        return size;
    }

    private class LinkedListIterator implements Iterator {
        Node currentNode = head;

        @Override
        public boolean hasNext() {
            if (currentNode.getNext() == null) {
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            if (currentNode == head) {
                currentNode = currentNode.getNext();
                return head;
            }

            Node next = currentNode.getNext();
            currentNode = next;
            return next;
        }
    }
}
