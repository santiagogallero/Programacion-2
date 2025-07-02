package org.example.model;

import java.util.PriorityQueue;

public class RepeatedStackTDA implements IStack {

    private static class Dupla implements Comparable<Dupla> {
        int valor;
        int cantidad;

        public Dupla(int valor) {
            this.valor = valor;
            this.cantidad = 1; // Initialize cantidad properly
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Dupla)) return false;
            Dupla d = (Dupla) o;
            return this.valor == d.valor && this.cantidad == d.cantidad;
        }

        @Override
        public int hashCode() {
            return 31 * valor + cantidad; // Fix method name
        }

        @Override
        public int compareTo(Dupla o) {
            return Integer.compare(this.valor, o.valor); // Compare based on valor
        }

        @Override
        public String toString() {
            return "(" + valor + ", " + cantidad + ")";
        }
    }

    private static class Triple implements Comparable<Triple> {
        @Override
        public int compareTo(Triple o) {
            return 0;
        }
    }

    private PriorityQueue<Dupla> pila;

    public RepeatedStackTDA(int capacidadInicial) {
        if (capacidadInicial <= 0) {
            throw new IllegalArgumentException("Capacidad debe ser mayor que 0.");
        }
        this.pila = new PriorityQueue<>();
    }

    public void add(int a) {
        if (!pila.isEmpty() && pila.peek().valor == a) {
            pila.peek().cantidad++;
        } else {
            pila.add(new Dupla(a));
        }
    }

    public void remove() {
        if (pila.isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        Dupla tope = pila.peek();
        if (tope.cantidad > 1) {
            tope.cantidad--;
        } else {
            pila.poll(); // Remove the entire Dupla
        }
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public int getTop() {
        if (pila.isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return pila.peek().valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contenido de la pila (de abajo hacia arriba):\n");
        for (Dupla d : pila) {
            sb.append(d).append("\n");
        }
        return sb.toString();
    }
}