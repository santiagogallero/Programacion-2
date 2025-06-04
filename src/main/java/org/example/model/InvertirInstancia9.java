package org.example.model;

public class InvertirInstancia9 {
    private int[] elementos;
    private int size;

    public InvertirInstancia9(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser mayor que cero.");
        }
        this.size = size;
        this.elementos = new int[size];
    }
    public void add(int a) {
        if (a < 0 || a >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + a);
        }
        elementos[a]++;
    }
    public void invertir(){
        int n = elementos.length;
        for(int i = 0; i < n / 2; i++) {
            int temp = elementos[i];
            elementos[i] = elementos[n - i - 1];
            elementos[n - i - 1] = temp;
        }
    }
    public int getCount(int a) {
        if (a < 0 || a >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + a);
        }
        return elementos[a];
    }
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (elementos[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public void remove(int a) {
        if (a < 0 || a >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + a);
        }
        if (elementos[a] > 0) {
            elementos[a]--;
        }
    }
}
