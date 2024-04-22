package FilaPrioridade;

public class Node <T> {
    T dado;
    int prioridade;
    Node<T> anterior;
    Node<T> proximo;

    public Node(T dado, int prioridade) {
        this.dado = dado;
        this.prioridade = prioridade;
        this.anterior = null;
        this.proximo = null;
    }
}
