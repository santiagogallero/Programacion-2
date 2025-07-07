package org.example.Entregable1;

import java.util.List;

public interface IMultiset {
    void add(int elem);              // agrega una ocurrencia del elemento
    void remove(int elem);           // elimina una ocurrencia (si hay)
    int count(int elem);             // cuántas veces aparece un elemento
    boolean contains(int elem);      // al menos una vez
    boolean isEmpty();               // no hay ningún elemento
    int size();                      // cardinal total (con repeticiones)
    List<Integer> elements();        // todos los elementos, incluyendo repes
}
