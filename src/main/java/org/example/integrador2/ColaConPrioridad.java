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
}
