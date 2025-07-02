package org.example.integrador2;

public class AtomicPredicate implements Predicate{
    private int value;
    public AtomicPredicate(int value) {
        this.value = value;
    }
    public boolean eval(int a) {
        return a == value;
    }
}
