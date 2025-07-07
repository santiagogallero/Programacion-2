package org.example.integrador2;

import org.example.model.IStack;

import java.util.ArrayList;
import java.util.List;

public class PilaDuplaConArrayList implements IStack {

    private List<Integer> elementos = new ArrayList<>();

    public PilaDuplaConArrayList(List<Integer> elementos) {
        this.elementos = elementos;
    }



    @Override
    public void add(int a) {
        elementos.add(a);

    }

    @Override
    public void remove() {
        if(!isEmpty()){
            elementos.remove(elementos.size() - 1);
        } else {
            throw new IllegalStateException("Stack is empty, cannot remove element.");
        }

    }

    @Override
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    @Override
    public int getTop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty, cannot get top element.");
        return elementos.get(elementos.size() - 1);
    }
    public List<Integer> getElementos() {
        return elementos;
    }
    public void agregarEnElFondoSiNoExiste(IStack pila, int elemento) {
        if (pila.isEmpty()) {
            pila.add(elemento);
            return;
        }

        int tope = pila.getTop();
        pila.remove();

        agregarEnElFondoSiNoExiste(pila, elemento);

        if (tope == elemento) {
            // ya estaba, no lo agrego de nuevo
            return;
        }

        pila.add(tope);
    }


}
