package PilhaEstatica;

public class PilhaEstatica {
    private Integer[] vetor = new Integer[10];
    private int cont = 0;

    public void push(int elem) {
        if (cont == vetor.length) {
            aumentaArray();
        }

        vetor[cont] = elem;
        cont++;
    }

    public void pop() {
        vetor[cont-1] = null;
        cont--;
    }

    public Integer peek() {
        return vetor[cont-1];
    }

    public boolean empty() {
        return cont == 0;
    }

    public int search(int obj) {
        for (int i = 0; i < cont; i++) {
            if (obj == vetor[i]) {
                return cont - i - 1;
            }
        }

        return -1;
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < cont; i++) {
            if (i == cont - 1) {
                System.out.print(vetor[i]);
            } else {
                System.out.print(vetor[i] + ", ");
            }
        }

        System.out.println("]");
    }

    private void aumentaArray() {
        Integer[] novoVetor = new Integer[(int)(vetor.length*1.5)];

        for (int i = 0; i < cont; i++) {
            novoVetor[i] = vetor[i];
        }

        vetor = novoVetor;
    }
}
