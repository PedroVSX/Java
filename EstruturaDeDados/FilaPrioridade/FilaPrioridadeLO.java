package FilaPrioridade;

public class FilaPrioridadeLO <T> {
    private Node<T> primeiro;
    private Node<T> ultimo;
    private int cont = 0;

    public void enqueue(T dado, int prioridade) {
        Node<T> novo = new Node<>(dado, prioridade);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            if (novo.prioridade < primeiro.prioridade) {
                novo.proximo = primeiro;
                primeiro.anterior = novo;
                primeiro = novo;
            } else if (novo.prioridade >= ultimo.prioridade) {
                novo.anterior = ultimo;
                ultimo.proximo = novo;
                ultimo = novo;
            } else {
                Node<T> aux = primeiro;

                while (novo.prioridade >= aux.prioridade) {
                    aux = aux.proximo;
                }

                novo.proximo = aux;
                aux.anterior.proximo = novo;
                novo.anterior = aux.anterior;
                aux.anterior = novo;
            }
        }

        cont++;
    }

    public void dequeue() {
        if (cont >= 1) {
            primeiro = primeiro.proximo;
            cont--;
        } else {
            clear();
        }
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
                System.out.print(aux.dado + " ");
                aux = aux.proximo;
            }
        }
        System.out.println("]");
    }
}
