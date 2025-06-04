package org.example.model;

public class StaticStackWithNode4 implements IStack {
    private Node top;
    private int count;
    private final int maxCapacity;

    public StaticStackWithNode4(int maxCapacity) {
        this.top = null;
        this.count = 0;
        this.maxCapacity = maxCapacity;
    }
    @Override
    public void add(int a) {
        if (count >= maxCapacity) {
            System.out.println("Error, la pila no tiene suficiente espacio para apilar el elemento");
            return;
        }
        Node newNode = new Node(a);
        newNode.next = top;
        top = newNode;
        count++;
    }
    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacía");
            return;
        }
        top = top.next;
        count--;
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public int getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacía");
            return -1;
        }
        return top.data;
    }
}
