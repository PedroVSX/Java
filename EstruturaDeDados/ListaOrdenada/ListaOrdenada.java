package ListaOrdenada;

public class ListaOrdenada {

    private Node primeiro;
    private Node ultimo;
    private int cont = 0;

    public void add(int elem) {
        Node novo = new Node(elem);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;

        } else if (novo.dado < primeiro.dado) {
            primeiro.anterior = novo;
            novo.proximo = primeiro;
            primeiro = novo;

        } else if (novo.dado >= ultimo.dado) {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;

        } else {
            Node aux = primeiro;

            while (novo.dado >= aux.dado) {
                aux = aux.proximo;
            }

            novo.proximo = aux;
            aux.anterior.proximo = novo;
            novo.anterior = aux.anterior;
            aux.anterior = novo;
        }

        cont++;
    }

    public int size() {
        return cont;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        cont = 0;
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
        Node aux = primeiro.proximo;
        boolean found = false;

        if (primeiro == obj) {
            primeiro = primeiro.proximo;
            primeiro.anterior = null;
            found = true;

        } else if (ultimo == obj) {
            ultimo = ultimo.anterior;
            ultimo.proximo = null;
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
        Node aux = primeiro.proximo;
        boolean found = false;

        if (pos == 0) {
            primeiro = primeiro.proximo;
            found = true;

        } else if (pos == cont-1) {
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

    public Integer get(int pos) {
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
