package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ArraySet implements ISet {
    private List<Integer> elements= new ArrayList<>();

    @Override
    public void add(int a) {
        if(!elements.contains(a)){
            elements.add(a);
        }

    }

    @Override
    public void remove(int a) {
        if (elements.contains(a)) {
            elements.remove(Integer.valueOf(a));
        }

    }

    @Override
    public int choose() {
        if(elements.isEmpty()) {
            throw new IllegalStateException("Set is empty, cannot choose an element.");
        }
        return elements.get(0); // Returns the first element as a representative
    }

    @Override
    public boolean isEmpty() {

        return elements.isEmpty();
    }
}
