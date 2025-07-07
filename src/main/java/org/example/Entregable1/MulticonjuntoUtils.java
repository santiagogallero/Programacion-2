package org.example.Entregable1;

public class MulticonjuntoUtils {
    public static IMultiset union(IMultiset a, IMultiset b) {
        IMultiset result = new Multiconjunto();
        for(int e:a.elements()){
            result.add(e);
        }
        for (int e:b.elements()){
            int cantA= a.count(e);
            int cantB= b.count(e);
            int cantTotal = cantA + cantB;
            if (cantB>cantTotal){
                int extra= cantB - cantTotal;
                for(int i=0; i<extra; i++){
                    result.add(e);
                }
            }
        }
        return result;
    }

    public static IMultiset interseccion(IMultiset a, IMultiset b) {

        IMultiset result = new Multiconjunto();
        for(int e : a.elements()) {
            if(result.contains(e)) continue; // Skip if already added)

            if(b.contains(e)){
                int repeticiones = Math.min(a.count(e), b.count(e));
                for (int i = 0; i < repeticiones; i++) {
                    result.add(e);
                }
            }
        }
        return result;
    }

    public static int cardinal(IMultiset m) {

        return m.size();
    }

    public static IMultiset diferencia(IMultiset a, IMultiset b) {
        IMultiset result = new Multiconjunto();
        for(int e : a.elements()){
            if(result.contains(e)) continue;

            int cant = a.count(e) - b.count(e);
            if(cant > 0) {
                for(int i = 0; i < cant; i++) {
                    result.add(e);
                }
            }
        }
        return result;

    }

    public static IMultiset diferenciaSimetrica(IMultiset a, IMultiset b) {
        // a implementar
        IMultiset ab = diferencia(a, b);
        IMultiset ba = diferencia(b, a);
        return union(ab, ba);
    }

    public static boolean subconjunto(IMultiset a, IMultiset b) {
        // a implementar
        IMultiset result = new Multiconjunto();
        for(int e:a.elements()){
            if(b.count(e) < a.count(e)) {
                return false; // If b does not contain enough of e, a is not a subset of b
            }
        }
        return true; // If all elements of a are present in b with sufficient count
    }

    public static boolean igualdad(IMultiset a, IMultiset b) {
        if (a.size() != b.size()) {
            return false; // If sizes differ, they cannot be equal
        }
        for(int e :a.elements()){
            if(a.count(e) != b.count(e)) {
                return false; // If counts of any element differ, they are not equal
            }
        }
        return true; // If all elements and their counts match, they are equal
    }
}
