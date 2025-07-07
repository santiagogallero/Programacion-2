package org.example.integrador2024;

import org.example.model.ISet;

import java.util.ArrayList;
import java.util.List;

public class SetIntegrador3  implements ISet {
    int suma = 0;
    List<Integer> elementos = new ArrayList<>();

    @Override
    public void add(int a) {
        for (int elem : elementos) {
            suma += elem;
        }
        int sumaTotal = suma + a;
        if (sumaTotal % 3 == 0 && !elementos.contains(a)) {
            elementos.add(a);
        }


    }

    @Override
    public void remove(int a) {
        if (!elementos.contains(a)) {
            throw new IllegalArgumentException("Element not found in the set.");
        }
        int suma = 0;
        for (int elem : elementos) {
            suma += elem;
        }
        int sumaRestante = suma - a;
        if (sumaRestante % 3 == 0) {
            elementos.remove((Integer) a);
        }
    }

    @Override
    public int choose() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public int chooseCandidate() {
        int sumaTotal = 0;
        for (int elem : elementos) {
            sumaTotal += elem;

        }
        for (int elem : elementos) {
            int sumaRestante = sumaTotal - elem;
            if (sumaRestante % 3 == 0) {
                return elem; // Return the first element that satisfies the condition
            }
        }
        throw new IllegalStateException("No hay candidato válido para eliminar");
    }
}

