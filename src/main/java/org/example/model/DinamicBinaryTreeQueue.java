package org.example.model;
import org.example.model.node.BQNode;
public class DinamicBinaryTreeQueue implements BinaryTreeQueue{
    private BQNode first;

    public void add(IBinaryTree a){
        if (this.isEmpty()) {
           this.first = new BQNode(a, null);
           return;

        }
        BQNode candidate = first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new BQNode(a, null));
    }
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía.");
        }

        if (this.first.getNext() == null) {
            this.first = null;
            return;
        }

        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public IBinaryTree getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía.");
        }
        return this.first.getValue();
    }
}

