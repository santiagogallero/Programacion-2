

import org.example.integrador2.PilaDuplaConArrayList;
import org.example.model.IStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public static List<Integer> IntersectionStackQueue(IStack pila, Queue<Integer> cola) {
    List<Integer> resultado = new ArrayList<>();

    // Necesitamos una forma de recorrer la pila sin modificarla
    List<Integer> elementosPila = ((PilaDuplaConArrayList) pila).getElementos();

    for (int elem : elementosPila) {
        if (cola.contains(elem) && !resultado.contains(elem)) {
            resultado.add(elem);
        }
    }

    return resultado;
}

public void main() {
}
