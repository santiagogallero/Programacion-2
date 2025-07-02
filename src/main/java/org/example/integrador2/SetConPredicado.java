package org.example.integrador2;

import org.example.model.ISet;




public class SetConPredicado implements ISet {
    private Predicate pred;

    public SetConPredicado() {
        // Empezamos con el conjunto vacío:
        // es decir, un predicado que siempre devuelve false
        this.pred = new UnitaryPredicate(UnitaryPredicateEnum.NOT,
                new UnitaryPredicate(UnitaryPredicateEnum.IDENTITY,
                        new UnitaryPredicate(UnitaryPredicateEnum.NOT, new AtomicPredicate(0))));
    }
    @Override
    public void add(int a) {
        Predicate nuevo = new BiPredicate(BiPredicateEnum.OR, pred, new AtomicPredicate(a));
        pred = nuevo;

    }

    @Override
    public void remove(int a) {
        Predicate nota = new UnitaryPredicate(UnitaryPredicateEnum.NOT, new AtomicPredicate(a));
        Predicate nuevo = new BiPredicate(BiPredicateEnum.AND, pred, nota);
        pred=nuevo;

    }

    @Override
    public int choose() {
        for(int i=0;i <1000; i++){
            if(pred.eval(i))return i;
        }
        throw new IllegalStateException("Conjunto vacío");
    }

    @Override
    public boolean isEmpty() {
        for (int i =0; i<1000;i++){
            if(pred.eval(i)) return false;
        }
        return true;
    }
}
