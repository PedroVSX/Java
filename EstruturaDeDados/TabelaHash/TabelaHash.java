package TabelaHash;

import ListaDinamica.ListaDinamica;

public class TabelaHash {
    private ListaDinamica[] hash;

    public TabelaHash(int n) {
        this.hash = new ListaDinamica[n];
    }

    public void insert(int elem) {
        int pos = elem % hash.length;

        if (hash[pos] == null) {
            hash[pos] = new ListaDinamica();
        }

        hash[pos].add(elem);
    }

    public void remove(Integer elem) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != null) {
                hash[i].remove(elem);
            }
        }
    }

    public void show() {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != null) {
                hash[i].show();
            } else {
                System.out.println("[]");
            }
        }
    }
}
