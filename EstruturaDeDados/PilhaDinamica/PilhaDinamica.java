package PilhaDinamica;

public class PilhaDinamica <T> {
    private Node<T> primeiro;
    private Node<T> ultimo;
    private int cont;

    public PilhaDinamica() {
        this.primeiro = null;
        this.ultimo = null;
        cont = 0;
    }

    public T push(T elem) {
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

        return elem;
    }

    public T pop() {
        T obj = peek();

        if (cont > 1) {
            ultimo = ultimo.anterior;
            ultimo.proximo = null;
            cont--;
        } else {
            clear();
        }

        return obj;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        cont = 0;
    }

    public T peek() {
        if (ultimo != null) {
            return ultimo.dado;
        } else {
            return null;
        }
    }

    public boolean empty() {
        return cont == 0;
    }

    public int search(Object obj) {
        Node<T> aux = primeiro;

        for (int i = 0; i < cont; i++) {
            if (obj.equals(aux.dado)) {
                return cont - i - 1;
            }

            aux = aux.proximo;
        }

        return -1;
    }

    public boolean contains(Object obj) {
        Node<T> aux = primeiro;

        for (int i = 0; i < cont; i++) {
            if (aux.dado.equals(obj)) {
                return true;
            }
            aux = aux.proximo;
        }

        return false;
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
