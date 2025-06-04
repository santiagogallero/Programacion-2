package org.example.model;

/**
 * Clase para contar la cantidad de elementos.
 */
public class ContadorElementos7 {
    private int[] elementos;
    private int size;

    /**
     * Constructor para inicializar el contador con un tamaño específico.
     * @param size El tamaño del contador.
     */
    public ContadorElementos7(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser mayor que cero.");
        }
        this.size = size;
        this.elementos = new int[size];
    }

    /**
     * Agrega una unidad al contador del elemento especificado.
     * @param a El índice del elemento.
     */
    public void add(int a) {
        if (a < 0 || a >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + a);
        }
        elementos[a]++;
    }

    /**
     * Remueve una unidad del contador del elemento especificado.
     * @param a El índice del elemento.
     */
    public void remove(int a) {
        if (a < 0 || a >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + a);
        }
        if (elementos[a] > 0) {
            elementos[a]--;
        }
    }

    /**
     * Obtiene la cantidad de unidades del elemento especificado.
     * @param a El índice del elemento.
     * @return La cantidad de unidades del elemento.
     */
    public int getCount(int a) {
        if (a < 0 || a >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + a);
        }
        return elementos[a];
    }

    /**
     * Verifica si todos los contadores están vacíos.
     * @return true si todos los contadores están vacíos, false en caso contrario.
     */
    public boolean isEmpty() {
        for (int count : elementos) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}
