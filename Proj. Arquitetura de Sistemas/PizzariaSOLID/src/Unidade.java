import java.util.function.ToDoubleBiFunction;

public class Unidade {

    private String endereco;
    private boolean disponibilidade; // true = aberto | false = fechado
    private Pedidos pedidos;

    public Unidade(String endereco, boolean disponibilidade) {
        this.endereco = endereco;
        this.disponibilidade = disponibilidade;
        this.pedidos = new Pedidos();
    }

    public String getEndereco() {
        return endereco;
    }

    public boolean taDisponivel() {
        return disponibilidade;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void abrir() {
        disponibilidade = true;
        System.out.println("A unidade em " + endereco + " acabou de abrir :D");
    }

    public void fechar() {
        disponibilidade = false;
        System.out.println("A unidade em " + endereco + " acabou de fechar :(");
    }

    @Override
    public String toString() {
        String disp = disponibilidade ? "Aberto" : "Fechado";

        return  "Unidade em " + endereco + "\n" +
                "Disponibilidade: " + disp;
    }
}
