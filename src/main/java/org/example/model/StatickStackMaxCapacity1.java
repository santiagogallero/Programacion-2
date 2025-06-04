package org.example.model;

public class StatickStackMaxCapacity1 implements IStack {
    private final int[] array;
    private int count;
    private final int MaxCapacity;

    public StatickStackMaxCapacity1(int MaxCapacity) {
        this.array = new int[MaxCapacity];
        this.count = 0;
        this.MaxCapacity = MaxCapacity;
    }
    @Override
    public void add(int a){
        if (count >= MaxCapacity){
            System.out.println("Error: la pila ha alcanzado su capacidad maxima");
            return;
        }
        this.array[count++] = a;
    }
    public void remove(){
        if (count == 0){
            System.out.println("Error: no se puede desapilar una pila vacia");
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
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacía");
            return -1;
        }
        return this.array[this.count-1];
    }
}
