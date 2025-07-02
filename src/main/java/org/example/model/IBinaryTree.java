package org.example.model;

import java.util.function.Predicate;

public interface IBinaryTree {
    int getRoot();
    IBinaryTree getLeft();
    IBinaryTree getRight();
    void addLeft(int a);
    void addRight(int a);
    IBinaryTree remove(int valor);
    void removeLeft();
    void removeRight();
    int contarInternosQueCumplen(Predicate<Integer> condicion);
    IBinaryTree espejo();
    boolean esLista();
    boolean esABB();
    boolean esDiccionarioMultiple();
    void reemplazar(int valorBuscado, int nuevoValor);

}
