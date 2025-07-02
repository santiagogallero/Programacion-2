package org.example.integrador2;

public class BiPredicate implements Predicate{
    private BiPredicateEnum type;
    private Predicate left;
    private Predicate right;

    public BiPredicate(BiPredicateEnum type, Predicate left, Predicate right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }
    public boolean eval(int x) {
        switch (type) {
            case AND:
                return left.eval(x) && right.eval(x);
            case OR:
                return left.eval(x) || right.eval(x);
            default:
                throw new IllegalStateException("Tipo no soportado");
        }
    }
    public BiPredicateEnum getType() {
        return type;
    }
    public Predicate getLeft() {
        return left;
    }
    public Predicate getRight() {
        return right;
    }

}
