package org.example.model;


public class StaticStack implements IStack {
    private final int [] array;
    private int count;
    //Modificar el TDA Stack para que tenga una capacidad máxima


    public StaticStack() {
        this.array = new int [10000];
        this.count = 0;

    }
    @Override
    public void add(int a) {
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if (count == 0){
            System.out.println("Error, no se puede apilar una pila vacia");
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
            System.out.println("Error, no se puede apilar un pila vacia");
            return -1;
        }
        return this.array[this.count-1];
    }
    public void revert(){
        if(isEmpty()){
            System.out.println("Error, no se puede revertir una pila vacia");
            return;
        }
        int i = 0;
        int j = this.count - 1;
        while (i < j) {
            int temp = this.array[i];
            this.array[i] = this.array[j];
            this.array[j] = temp;
            i++;
            j--;
        }
    }
}
