public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Pizzaria pizzaria = new Pizzaria();

        Unidade unidadeAldeota = new Unidade("Aldeota", true);
        Unidade unidadePapicu = new Unidade("Papicu", false);

        pizzaria.adicionarUnidade(unidadeAldeota);
        pizzaria.adicionarUnidade(unidadePapicu);

        menu.iniciar(pizzaria);
    }

}
