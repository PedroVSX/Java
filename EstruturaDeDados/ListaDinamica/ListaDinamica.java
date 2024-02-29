public class ListaDinamica {

    private Node primeiro;
    private Node ultimo;

    private int cont = 0;

    public void add(Object elem) {
        Node novo = new Node(elem);

        if (primeiro.dado == null){
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
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
        aux.proximo = novo;

        cont++;
    }

    public int size() {
        return cont;
    }

    public void clear() {

    }

    public boolean contains(Object obj) {
        return true;    
    }

    public void remove(Object obj) {

    }

    public void remove(int pos) {

    }

    public Object get(int pos) {
        return "oi";
    }

    public int indexOf(Object obj) {
        return -1;
    }

    public void show() {
        Node aux = new Node(primeiro.dado);

        System.out.print("[");
        for (int i = 0; i < cont; i++) {
            if (i == cont-1) {
                System.out.printf("%s",aux.dado);
            } else {
                System.out.printf("%s, ", aux.dado);
                aux = primeiro.proximo;
            }
        }
        System.out.println("]");
    }

    private void aumentaArray() {

    }


}
