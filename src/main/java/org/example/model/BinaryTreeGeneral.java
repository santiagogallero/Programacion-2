package org.example.model;

import java.util.function.Predicate;

public class BinaryTreeGeneral implements IBinaryTree {
    private int root;
    private IBinaryTree left;
    private IBinaryTree right;

    public BinaryTreeGeneral(int root) {
        this.root = root;
        this.left = null;
        this.right = null;
    }

    @Override
    public int getRoot() {
        return root;
    }

    @Override
    public IBinaryTree getLeft() {
        return left;
    }

    @Override
    public IBinaryTree getRight() {
        return right;
    }

    @Override
    public void addLeft(int a) {
        this.left = new BinaryTreeGeneral(a);

    }

    @Override
    public void addRight(int a) {
        this.right = new BinaryTreeGeneral(a);
    }

    public void addLeft(IBinaryTree tree) {
        this.left = tree;
    }

    public void addRight(IBinaryTree tree) {
        this.right = tree;
    }

    @Override
    public void removeLeft() {
        this.left = null;
    }

    @Override
    public void removeRight() {
        this.right = null;
    }


    public int contarInternosQueCumplen(Predicate<Integer> condicion) {
        boolean esInterno = (this.left != null || this.right != null);
        boolean cumple = condicion.test(this.root);

        int count = (esInterno && cumple) ? 1 : 0;

        if (this.left != null)
            count += this.left.contarInternosQueCumplen(condicion);
        if (this.right != null)
            count += this.right.contarInternosQueCumplen(condicion);

        return count;
    }

    public IBinaryTree espejo() {
        BinaryTreeGeneral nuevo = new BinaryTreeGeneral(this.root);
        if (this.right != null) {
            nuevo.left = this.right.espejo();
        }
        if (this.left != null) {
            nuevo.right = this.left.espejo();
        }
        return nuevo;
    }
    public boolean esLista(){
        if(this.left != null && this.right != null) {
            return false;
        }
        if(this.left != null) {
            return this.left.esLista();
        }
        if(this.right != null) {
            return this.right.esLista();
        }
        return true;
    }
    public boolean esABB(){
        return esABBHelper(this, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean esABBHelper(BinaryTreeGeneral nodo, int min, int max) {
        if (nodo == null) {
            return true;
        }
        int valor = nodo.getRoot();

        if (valor< min || valor > max) {
            return false;
        }
        return esABBHelper((BinaryTreeGeneral) nodo.getLeft(), min, valor) && esABBHelper((BinaryTreeGeneral) nodo.getRight(), valor, max);
    }
    public boolean esDiccionarioMultiple() {
       return esDiccionarioMultiple(this, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean esDiccionarioMultiple(BinaryTreeGeneral nodo, int min, int max) {
        if (nodo == null) {
            return true;
        }
        int valor = nodo.getRoot();

        if (valor < min || valor > max) {
            return false;
        }
        return esDiccionarioMultiple((BinaryTreeGeneral)nodo.getLeft(), min, valor-1) &&
               esDiccionarioMultiple((BinaryTreeGeneral) nodo.getRight(), valor, max);
    }
    public void reemplazar(int valorBuscado, int nuevoValor) {
        if (this.root == valorBuscado) {
            this.root = nuevoValor;
            return;
        }
        if (this.left != null) {
            this.left.reemplazar(valorBuscado, nuevoValor);
        }
        if (this.right != null) {
            this.right.reemplazar(valorBuscado, nuevoValor);
        }
    }
    public IBinaryTree remove(int valor) {
        if (valor < this.root) {
            if (this.left != null) {
                this.left = this.left.remove(valor);
            }
            return this;
        } else if (valor > this.root) {
            if (this.right != null) {
                this.right = this.right.remove(valor);
            }
            return this;
        } else {
            // Caso 1: sin hijos
            if (this.left == null && this.right == null) {
                return null;
            }
            // Caso 2: un solo hijo
            if (this.left == null) {
                return this.right;
            }
            if (this.right == null) {
                return this.left;
            }
            // Caso 3: dos hijos
            IBinaryTree sucesor = encontrarMinimo(this.right);
            this.root = sucesor.getRoot(); // reemplaza el valor
            this.right = this.right.remove(sucesor.getRoot()); // elimina el nodo duplicado
            return this;
        }
    }
    private IBinaryTree encontrarMinimo(IBinaryTree nodo) {
        while (nodo.getLeft() != null) {
            nodo = nodo.getLeft();
        }
        return nodo;
    }
}
