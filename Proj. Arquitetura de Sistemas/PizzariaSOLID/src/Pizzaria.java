import java.util.ArrayList;

public class Pizzaria {

    private ArrayList<Unidade> unidades = new ArrayList<>();

    public void adicionarUnidade(Unidade unidade) {
        unidades.add(unidade);
        System.out.println("Unidade adicionada em " + unidade.getEndereco());
    }

    public void removerUnidade(Unidade unidade) {
        unidades.add(unidade);
        System.out.println("Unidade adicionada em " + unidade.getEndereco());
    }

    public void getListaUnidades() {
        int i = 1;
        for (Unidade unidade : unidades) {
            System.out.println(i + " - " + unidade + "\n");
            i++;
        }
    }

    public ArrayList<Unidade> getUnidades() {
        return unidades;
    }

    public Unidade getUnidadeEspecifica(int i) {
        return unidades.get(i);
    }
}
