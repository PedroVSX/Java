package ListaOrdenada;

public class Node {

    Integer dado;
    Node anterior;
    Node proximo;

    public Node(int dado) {
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
}
