package org.example.model;

public interface SetOfSet {
    void add(ISet a);
    void remove(ISet a);
    ISet choose();
    boolean isEmpty();
}
