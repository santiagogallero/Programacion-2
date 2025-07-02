package org.example.integrador2;

public class PredicateOptimazer {
    public Predicate optimize(Predicate p ){
        if( p instanceof UnitaryPredicate){
            UnitaryPredicate up =(UnitaryPredicate) p;
            Predicate interno = optimize(up.getPred());
            if (up.getType()== UnitaryPredicateEnum.NOT
                    && interno instanceof UnitaryPredicate
                    && ((UnitaryPredicate)interno).getType()==UnitaryPredicateEnum.NOT){
                return ((UnitaryPredicate)interno).getPred();
            }
            return new UnitaryPredicate(up.getType(),interno);
        }
       if (p instanceof  BiPredicate){
            BiPredicate bp = (BiPredicate) p;
            Predicate left = optimize(bp.getLeft());
            Predicate right = optimize(bp.getRight());
          if (bp.getType() == BiPredicateEnum.AND && left.equals(right)) {
                return left;
          }
          if (bp.getType() == BiPredicateEnum.OR && left.equals(right)) {
                return left;
          }
          return new BiPredicate(bp.getType(), left, right);

        }
       return p;

       }
    }

