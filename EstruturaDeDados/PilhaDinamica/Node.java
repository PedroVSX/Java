package PilhaDinamica;

public class Node <T> {
    T dado;
    Node<T> proximo;
    Node<T> anterior;

    public Node(T elem) {
        this.dado = elem;
        this.proximo = null;
        this.anterior = null;
    }
}
