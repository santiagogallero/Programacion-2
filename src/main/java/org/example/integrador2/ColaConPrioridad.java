package org.example.integrador2;

import java.util.List;

public class ColaConPrioridad {
    protected List<PrioridadValor> datos;

    public ColaConPrioridad(List<PrioridadValor> datos) {
        this.datos = datos;
    }
    public void add(int prioridad, int valor) {
        int i=0;
        while(i<datos.size() && datos.get(i).getPrioridad() < prioridad) {
            i++;
        }
        datos.add(i, new PrioridadValor(prioridad, valor));
    }
    public PrioridadValor poll() {
        if(datos.isEmpty()) {
            throw new IllegalStateException("Cola vacía, no se puede extraer un elemento.");
        }
        return datos.remove(0); // Extrae el primer elemento (el de mayor prioridad)
    }
    public boolean isEmpty() {
        return datos.isEmpty();
    }
    public int size() {
        return datos.size();
    }
    public PrioridadValor get(int index){
        return datos.get(index);
    }

    private int binarySearch(int prioridad){
        int left = 0;
        int right = datos.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int actual = datos.get(mid).getPrioridad();

            if (actual == prioridad) {
                return mid; // Encontrado
            } else if (actual < prioridad) {
                left = mid + 1; // Buscar en la mitad derecha
            } else {
                right = mid - 1; // Buscar en la mitad izquierda
            }
        }
        // No encontrado → devuelve la posición donde debería insertarse
        return -(left+1); // No encontrado
    }
}
