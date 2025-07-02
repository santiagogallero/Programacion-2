package org.example.model.node;
import org.example.model.IBinaryTree;

public class BQNode {
    private final IBinaryTree value;
    private BQNode next;

    public BQNode(IBinaryTree value, BQNode next) {
        this.value = value;
        this.next = null;
    }
    public IBinaryTree getValue() {
        return value;
    }
    public BQNode getNext() {
        return next;
    }
    public void setNext(BQNode next) {
        this.next = next;
    }
}
