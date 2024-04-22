package FilaPrioridade;

public class FilaPrioridadeLNO <T> {
    Node<T> primeiro;
    Node<T> ultimo;
    int cont;

    public void enqueue(T dado, int prioridade) {
        Node<T> novo = new Node<>(dado, prioridade);

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
        if (cont > 1) {
            Node<T> aux = null;
            int i = 0;

            while (aux == null) {
                aux = findByPriority(i);
                i++;
            }

            T dado = aux.dado;

            if (aux == primeiro) {
                primeiro = primeiro.proximo;
                primeiro.anterior = null;
                cont--;

            } else if (aux == ultimo) {
                ultimo = ultimo.anterior;
                ultimo.proximo = null;
                cont--;

            } else {
                aux.anterior.proximo = aux.proximo;
                aux.proximo.anterior = aux.anterior;
                cont--;

            }

            return dado;

        } else {
            if (cont == 1) {
                return primeiro.dado;
            }
            clear();
        }

        return null;
    }

    private Node<T> findByPriority(int prioridade) {
        Node<T> aux = primeiro;

        while (aux != null && aux.prioridade != prioridade) {
            aux = aux.proximo;
        }

        return aux;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        cont = 0;
    }

    public T front() {
        return primeiro.dado;
    }

    public boolean empty() {
        return cont == 0;
    }

    public void show() {
        Node<T> aux = primeiro;

        System.out.print("[");
        for (int i = 0; i < cont; i++) {
            if (i == cont-1) {
                System.out.print(aux.dado);
            } else {
                System.out.print(aux.dado + ", ");
                aux = aux.proximo;
            }
        }
        System.out.println("]");
    }
}
