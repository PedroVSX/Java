package ListaEstatica;

public class ListaEstatica {

    private int[] vetor = new int[0];
    private int cont = 0;

    public void add(int elem) {
        if (cont == vetor.length) {
            aumentaArray();

        }

        vetor[cont] = elem;
        cont++;

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
        int[] novoVetor = new int[vetor.length + 1];

        for (int i = 0; i < vetor.length; i++) {
            novoVetor[i] = vetor[i];

        }

        vetor = novoVetor;

    }

}

