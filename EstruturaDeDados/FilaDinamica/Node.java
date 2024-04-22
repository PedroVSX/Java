package FilaDinamica;

public class Node <T> {
    T dado;
    Node<T> proximo;
    Node<T> anterior;

    public Node(T dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }
}
