package org.example.util;
import org.example.model.BinaryTreeGeneral;
import org.example.model.IBinaryTree;
import org.example.model.BinaryTreeQueue;
import org.example.model.node.BQNode;
import org.example.model.DinamicBinaryTreeQueue;


public class BinaryTreeUtil {
    public BinaryTreeUtil() {
        // Private constructor to prevent instantiation
    }

    public static int totalNodes(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }
        int i = totalNodes(binaryTree.getLeft());
        int r = 1;
        int d = totalNodes(binaryTree.getRight());
        return i + r + d;
    }

    public static int totalLeaves(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }
        int i = totalLeaves(binaryTree.getLeft());
        int r = binaryTree.getLeft() == null && binaryTree.getRight() == null ? 1 : 0;
        int d = totalLeaves(binaryTree.getRight());
        return i + r + d;
    }

    public int totalIntern(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }
        return totalInternAux(binaryTree, false);
    }

    private static int totalInternAux(IBinaryTree binaryTree, boolean isIntern) {
        if (binaryTree == null) {
            return 0;
        }
        int i = totalInternAux(binaryTree.getLeft(), true);
        int r = isIntern && (binaryTree.getLeft() != null || binaryTree.getRight() != null) ? 1 : 0;
        int d = totalInternAux(binaryTree.getRight(), true);
        return i + r + d;
    }

    public static int height(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static boolean isComplete(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            return true;
        }
        if (binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return false;
        }
        if (binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            return false;
        }
        return isComplete(binaryTree.getLeft()) && isComplete(binaryTree.getRight());
    }

    public static boolean isFull(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            return true;
        }
        if (binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return false;
        }
        if (binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            return false;
        }
        return isFull(binaryTree.getLeft()) &&
                isFull(binaryTree.getRight()) &&
                height(binaryTree.getLeft()) == height(binaryTree.getRight());
    }

    public static boolean isFull2(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            return true;
        }
        int totalNodes = totalNodes(binaryTree.getLeft());
        int aux = totalNodes + 1;
        int exp = (int) (Math.log(aux) / Math.log(2));
        if (Math.pow(2, exp) - 1 == aux) {
            return true;
        }
        return false;

    }

    public static void printPreOrder(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            System.out.println("null");
            return;
        }
        System.out.println(binaryTree.getRoot());
        printPreOrder(binaryTree.getLeft());
        printPreOrder(binaryTree.getRight());
    }

    public static void printInOrder(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            return;
        }
        printInOrder(binaryTree.getLeft());
        System.out.println(binaryTree.getRoot());
        printInOrder(binaryTree.getRight());
    }

    public static void postOrder(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            System.out.println("null");
            return;
        }
        postOrder(binaryTree.getLeft());
        postOrder(binaryTree.getRight());
        System.out.println(binaryTree.getRoot());
    }

    public static void printByLevel(IBinaryTree binaryTree) {
        if (binaryTree == null) {
            System.out.println("null");
            return;
        }
        BinaryTreeQueue binaryTreeQueue = new DinamicBinaryTreeQueue();
        binaryTreeQueue.add(binaryTree);

        while (!binaryTreeQueue.isEmpty()) {
            binaryTreeQueue.add(binaryTreeQueue.getFirst().getLeft());
            binaryTreeQueue.add(binaryTreeQueue.getFirst().getRight());

            System.out.println(binaryTreeQueue.getFirst().getRoot());

            binaryTreeQueue.remove();
        }
    }

    public static IBinaryTree fibonacci(int n) {
        if (n == 0) return new BinaryTreeGeneral(0);
        if (n == 1) return new BinaryTreeGeneral(1);

        IBinaryTree left = fibonacci(n - 1);
        IBinaryTree right = fibonacci(n - 2);
        int rootValue = ((BinaryTreeGeneral) left).getRoot() + ((BinaryTreeGeneral) right).getRoot();
        ;
        BinaryTreeGeneral tree = new BinaryTreeGeneral(rootValue);

        tree.addLeft(left);
        tree.addRight(right);
        return tree;
    }

    public static IBinaryTree crearTrianguloSimple(int fila, int maxFila) {
        if (fila > maxFila) return null;

        BinaryTreeGeneral nodo = new BinaryTreeGeneral(1);
        nodo.addLeft(crearTrianguloSimple(fila + 1, maxFila));
        return nodo;
    }

    private static int comb(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return comb(n - 1, k - 1) + comb(n - 1, k);
    }

    public static IBinaryTree crearZigZag(int nivel, int maxNivel, boolean izquierda) {
        if (nivel > maxNivel) return null;

        BinaryTreeGeneral nodo = new BinaryTreeGeneral(nivel);
        System.out.println("creando nodo: " + nivel + " izquierda=" + izquierda);

        if (izquierda) {
            nodo.addLeft(crearZigZag(nivel + 1, maxNivel, false));
        } else {
            nodo.addRight(crearZigZag(nivel + 1, maxNivel, true));
        }

        return nodo;
    }

    public static IBinaryTree crearArbolPascal(int fila, int col, int maxFila) {
        if (fila > maxFila|| col> fila) return null;
        int valor = comb(fila, col);

        BinaryTreeGeneral nodo = new BinaryTreeGeneral(valor);
        nodo.addLeft(crearArbolPascal(fila + 1, col, maxFila));
        nodo.addRight(crearArbolPascal(fila + 1, col + 1, maxFila));
        return nodo;
    }
    public static void printTree(IBinaryTree arbol) {
        printTree(arbol, 0);
    }

    private static void printTree(IBinaryTree arbol, int nivel) {
        if (arbol == null) {
            return;
        }
        printTree(arbol.getRight(), nivel + 1);
        System.out.println(" ".repeat(nivel * 4) + arbol.getRoot());
        printTree(arbol.getLeft(), nivel + 1);
    }
}

