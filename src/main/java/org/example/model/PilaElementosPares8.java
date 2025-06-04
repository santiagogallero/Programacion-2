package org.example.model;

public class PilaElementosPares8 {
    private int[] elementos;
    private int size;

    public PilaElementosPares8(int size) {
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
        if (a % 2 == 0) {
            elementos[a]++;
        } else {
            System.out.println("Error: solo se permiten elementos pares.");
        }
    }
    public void remove(int a) {
        if (a < 0 || a >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + a);
        }
        if (elementos[a] > 0) {
            elementos[a]--;
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
}
