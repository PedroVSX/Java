package ListaEstatica;

public class ListaEstatica {

    private Object[] vetor = new Object[0];
    private int cont = 0;

    public void add(Object elem) {
        if (cont == vetor.length) {
            aumentaArray();
        }

        vetor[cont] = elem;
        cont++;
    }

    public void add(int pos, Object elem) {
        if (cont == vetor.length) {
            aumentaArray();
        }

        for (int i = cont; i > 0; i--) {
            if(i > pos) {
                vetor[i] = vetor[i-1];
            }
        }

        vetor[pos] = elem;
        cont++;
    }

    public int size() {
        return cont;
    }

    public void clear() {
        vetor = new Object[0];
        cont = 0;
    }

    public boolean contains(Object obj) {
        for (int i = 0; i < cont; i++) {
            if (vetor[i] == obj) {
                return true;
            }
        }

        return false;
    }

    public void remove(Object obj) {
        ListaEstatica novaLista = new ListaEstatica();
        boolean rmvd = false;

        for (int i = 0; i < cont; i++) {
            if (vetor[i] != obj) {
                novaLista.add(vetor[i]);
            } else {
                rmvd = !rmvd;
            }
        }

        vetor = novaLista.getVetor();
        cont--;
    }

    public void remove(int pos) {
        ListaEstatica novaLista = new ListaEstatica();

        for (int i = 0; i < cont; i++) {
            if (i != pos) {
                novaLista.add(vetor[i]);
            }
        }

        vetor = novaLista.getVetor();
        cont--;
    }

    public Object get(int pos) {
        return vetor[pos];
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < cont; i++) {
            if (vetor[i] == obj) {
                return i;
            }
        }

        return -1;
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < cont; i++) {
            if(i == cont - 1) {
                System.out.print(vetor[i]);
            } else {
                System.out.printf("%s, ", vetor[i]);
            }

        }

        System.out.println("]");
    }

    private void aumentaArray() {
        Object[] novoVetor = new Object[vetor.length + 1];

        for (int i = 0; i < vetor.length; i++) {
            novoVetor[i] = vetor[i];
        }

        vetor = novoVetor;
    }
    private Object[] getVetor() {
        return vetor;
    }

}
