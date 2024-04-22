package FilaDinamica;

public class FilaDinamica <T> {
    private Node<T> primeiro;
    private Node<T> ultimo;
    private int cont = 0;

    public void enqueue(T elem) {
        Node<T> novo = new Node<>(elem);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        }

        cont++;
    }

    public T dequeue() {
        T aux = primeiro.dado;

        if (cont > 1) {
            primeiro = primeiro.proximo;
            cont--;
        } else {
            clear();
        }

        return aux;
    }

    public void clear() {
        cont = 0;
        primeiro = null;
        ultimo = null;
    }

    public boolean empty() {
        return cont == 0;
    }

    public T front() {
        return primeiro.dado;
    }

    public void show() {
        Node<T> aux = primeiro;

        System.out.print("[");
        for (int i = 0; i < cont; i++) {
            if (i == cont - 1) {
                System.out.print(aux.dado);
            } else {
                System.out.print(aux.dado + ", ");
            }
            aux = aux.proximo;
        }

        System.out.println("]");
    }
}
