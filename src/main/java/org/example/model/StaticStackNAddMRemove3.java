package org.example.model;

public class StaticStackNAddMRemove3 implements IStack {
    private final int [] array;
    private int count;
    private final int maxCapacity;
    private  int n;
    private  int m;

    public StaticStackNAddMRemove3(int n, int m, int maxCapacity) {
        this.array = new int[maxCapacity];
        this.count = 0;
        this.maxCapacity = maxCapacity;
        this.n = n;
        this.m = m;
    }
    public void add(int a){
        if(count + n > maxCapacity){
            System.out.println("Error, la pila no tiene suficiente espacio para apilar el elemento " + n + " veces");
            return;
        }
        for(int i=0;i<n;i++){
            this.array[count++] = a;
        }
    }
    public void remove(){
        if(count <m){
            System.out.println("Error, no se puede desapilar " + m + " elementos de una pila con menos de " + m + " elementos");
            return;
        }
        count-=m;
    }
    public boolean isEmpty(){
        return this.count == 0;
    }
    public int getTop(){
        if(count==0){
            System.out.println("Error, no se puede desapilar una pila vacía");
            return -1;
        }
        return this.array[count-1];
    }
}
