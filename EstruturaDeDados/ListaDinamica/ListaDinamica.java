package ListaDinamica;

public class ListaDinamica {

    private Node primeiro;
    private Node ultimo;
    private int cont = 0;

    public void add(Object elem) {
        Node novo = new Node(elem);
        Node aux;

        if (this.primeiro == null){
            this.primeiro = novo;
            this.ultimo = novo;

        } else {
            ultimo.proximo = novo;
            aux = ultimo;
            ultimo = novo;
            ultimo.anterior = aux;
        }

        cont++;
    }

    public void add(int pos, Object elem) {
        Node novo = new Node(elem);
        Node aux = primeiro;

        for (int i = 0; i < pos - 1; i++) {
            aux = aux.proximo;
        }

        novo.proximo = aux.proximo;
        aux.proximo.anterior = novo;
        aux.proximo = novo;
        novo.anterior = aux;

        cont++;
    }

    public int size() {
        return cont;
    }

    public void clear() {
        cont = 0;
        primeiro = null;
        ultimo = null;
    }

    public boolean contains(Object obj) {
        Node aux = primeiro;

        for (int i = 0; i < cont; i++) {
            if (aux.dado == obj) {
                return true;
            }
            aux = aux.proximo;
        }

        return false;
    }

    public void remove(Object obj) {
        Node aux = primeiro;
        boolean found = false;

        if (primeiro.dado == obj) {
            primeiro = primeiro.proximo;
            found = true;

        } else if (ultimo.dado == obj) {
            ultimo = ultimo.anterior;
            found = true;

        } else {
            for (int i = 1; i < cont - 1; i++) {
                if (aux.dado == obj) {
                    found = true;
                    break;
                }

                aux = aux.proximo;
            }

            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
        }

        if (found) {
            cont--;
        }
    }

    public void remove(int pos) {
        Node aux = primeiro;
        boolean found = false;

        if (pos == 0) {
            primeiro = primeiro.proximo;
            found = true;

        } else if (pos == cont - 1) {
            ultimo = ultimo.anterior;
            found = true;

        } else {
            for (int i = 1; i < cont - 1; i++) {
                if (i == pos) {
                    found = true;
                    break;
                }

                aux = aux.proximo;
            }

            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
        }

        if (found) {
            cont--;
        }
    }

    public Object get(int pos) {
        Node aux = primeiro;

        if (pos > cont-1 || pos < 0) {
            throw new IndexOutOfBoundsException("Index " + pos + " out of bounds for length " + cont);
        }

        for (int i = 0; i < cont; i++) {
            if (i == pos) {
                return aux.dado;
            } else {
                aux = aux.proximo;
            }
        }

        return 0;
    }

    public int indexOf(Object obj) {
        Node aux = primeiro;

        for (int i = 0; i < cont; i++) {
            if (aux.dado == obj) {
                return i;
            } else {
                aux = aux.proximo;
            }
        }

        return -1;
    }

    public void show() {
        Node aux = primeiro;

        System.out.print("[");
        for (int i = 0; i < cont; i++) {
            if (i == cont-1) {
                System.out.printf("%s",aux.dado);
            } else {
                System.out.printf("%s, ", aux.dado);
                aux = aux.proximo;
            }
        }
        System.out.println("]");
    }
}
