package org.example.model;

public class CharStack6 {
    private final char[] array;
    private int count;
    private final int maxCapacity;

    public CharStack6(int maxCapacity) {
        this.array = new char[maxCapacity];
        this.count = 0;
        this.maxCapacity = maxCapacity;
    }
    public void add(char c){
        if (count>= maxCapacity) {
            System.out.println("Error, la pila no tiene suficiente espacio para apilar el elemento");
            return;
        }
        this.array[count++] = c;
    }
    public void remove(){
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacía");
            return;
        }
        count--;
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public char getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacía");
            return ' ';
        }
        return this.array[count - 1];
    }

}
