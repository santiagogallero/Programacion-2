package org.example.integrador2;

import java.util.List;

public class SpecialPriorityQueue extends ColaConPrioridad {
    public SpecialPriorityQueue(List<PrioridadValor> datos) {
        super(datos);
    }

    public boolean tienePico() {
        if (datos.size() < 3) return false; // no hay suficiente para formar un pico

        for (int i = 1; i < datos.size() - 1; i++) {
            int anterior = datos.get(i - 1).getValor();
            int actual = datos.get(i).getValor();
            int siguiente = datos.get(i + 1).getValor();

            if (actual > anterior && actual > siguiente) {
                return true; // hay un pico
            }
        }

        return false; // no se encontró pico
    }
}
