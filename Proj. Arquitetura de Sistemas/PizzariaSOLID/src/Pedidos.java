import java.util.ArrayList;

public class Pedidos {

    private ArrayList<Pizza> itens = new ArrayList<>();

    public void adicionarPedido(Pizza pizza) {
        this.itens.add(pizza);
    }

    public void getListaPedidos() {
        int i = 1;
        for (Pizza pedidos : itens) {
            System.out.println(i + " - " + pedidos + "\n");
            i++;
        }
    }

    public ArrayList<Pizza> getPedidos() {
        return itens;
    }

}
