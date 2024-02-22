package ListaEstatica;

public class ListaEstatica {

    private Integer[] vetor = new Integer[0];
    private int cont = 0;

    public void add(int elem) {
        if (cont == vetor.length) {
            aumentaArray();
        }

        vetor[cont] = elem;
        cont++;

    }

    public void add(int pos, int elem) {
        aumentaArray();


    }

    public int size() {
        return cont;
    }

    public void clear() {

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

    }

    public void remove(int pos) {
        Integer[] novaLista = new Integer[vetor.length - 1];

        for (int i = 0; i < cont; i++) {
            if (i != pos) {
                novaLista[i] = vetor[i];
            }
        }

        vetor = novaLista;
    }

    public int get(int pos) {
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
        Integer[] novoVetor = new Integer[vetor.length + 1];

        for (int i = 0; i < vetor.length; i++) {
            novoVetor[i] = vetor[i];
        }

        vetor = novoVetor;

    }

}
