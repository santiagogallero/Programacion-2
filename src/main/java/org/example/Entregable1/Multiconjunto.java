package org.example.Entregable1;

import org.example.model.ISet;

import java.util.ArrayList;
import java.util.List;

public class Multiconjunto implements IMultiset {
    private List<Integer> elements=new ArrayList<>();

    public Multiconjunto() {
        this.elements = new ArrayList<>();
    }


    @Override
    public void add(int elem) {
        elements.add(elem);

    }

    @Override
    public void remove(int elem) {
        elements.remove((Integer) elem);

    }

    @Override
    public int count(int elem) {
        int contador = 0;
        for(int e : elements) {
            if (e == elem) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public boolean contains(int elem) {
        return elements.contains(elem);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public List<Integer> elements() {
        return new ArrayList<>(elements);
    }
}