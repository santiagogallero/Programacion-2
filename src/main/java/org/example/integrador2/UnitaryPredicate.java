package org.example.integrador2;

public class UnitaryPredicate implements Predicate{
    private UnitaryPredicateEnum type;
    private Predicate pred;
    public UnitaryPredicate(UnitaryPredicateEnum type, Predicate pred) {
        this.type = type;
        this.pred = pred;
    }
    public UnitaryPredicateEnum getType() {
        return type;
    }
    public Predicate getPred() {
        return pred;
    }
    public boolean eval(int x) {
        switch (type){
            case IDENTITY :
                return pred.eval(x);
            case NOT :
                return !pred.eval(x);
            default:
                throw new IllegalStateException("Tipo no soportado");
        }
    }
}
