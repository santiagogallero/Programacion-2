package org.example.model;

public class StaticStackDoubleAdd implements IStack{
    private final int[] array;
    private int count;
    private final int maxCapacity;

    public StaticStackDoubleAdd(int maxCapacity) {
        this.array = new int[maxCapacity];
        this.count = 0;
        this.maxCapacity = maxCapacity;
    }
    @Override
    public void add(int a){
        if(count + 2 > maxCapacity){
            System.out.println("Error, la pila no tiene suficiente espacio para apilar el elemento dos veces");
            return;
        }
        this.array[this.count++] = a;
        this.array[this.count++] = a;
    }
    @Override
    public void remove(){
        if (count ==0){
            System.out.println("Error, no se puede desapilar una pila vacía");
            return;
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
    @Override
    public int getTop(){
        if(count == 0){
            System.out.println("Error, no se puede desapilar una pila vacía");
            return -1;
        }
        return this.array[this.count-1];

    }
}
