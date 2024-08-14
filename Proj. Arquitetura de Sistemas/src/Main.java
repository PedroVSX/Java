import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Pizzaria pizzaria = new Pizzaria();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Unidade unidadeAldeota = new Unidade("Aldeota", true);
        Unidade unidadePapicu = new Unidade("Papicu", false);

        pizzaria.adicionarUnidade(unidadeAldeota);
        pizzaria.adicionarUnidade(unidadePapicu);

        menu();
    }

    public static void menu() throws IOException {
        System.out.print(
                """
                
                -----------------------------------------
                Bem-vindo(a) à Pizzaria Z!
                Qual das nossas unidades deseja utilizar?
                -----------------------------------------
                """
        );

        pizzaria.getListaUnidades();

        System.out.print("Digite sua escolha: ");
        int i = Integer.parseInt(input.readLine()) - 1;
        Unidade unidadeEscolhida = pizzaria.getUnidadeEspecifica(i);

        if (unidadeEscolhida.taDisponivel()) {
            System.out.print(
                    """
                    
                    -------------------------------
                    Legal! O que você deseja pedir?
                    -------------------------------
                    1 - Pizza de mussarela
                    2 - Pizza de calabresa
                    
                    """
            );

            System.out.print("Sua escolha: ");

            int sabor = Integer.parseInt(input.readLine());

            System.out.print(
                    """
                    
                    -----------------------------------------------------
                    Falta pouco! Qual o tamanho da pizza que você deseja?
                    -----------------------------------------------------
                    1 - Pequena
                    2 - Média
                    3 - Grande
                    
                    """
            );

            System.out.print("Sua escolha: ");

            int tamanhoEscolhido = Integer.parseInt(input.readLine());
            Pizza pizza;

            if (sabor == 1) {
                String tamanho = switch (tamanhoEscolhido) {
                    case 1 -> "P";
                    case 2 -> "M";
                    case 3 -> "G";
                    default -> throw new IllegalArgumentException("Opção inválida");
                };

                pizza = new PizzaMussarela(tamanho);

            } else {
                String tamanho = switch (tamanhoEscolhido) {
                    case 1 -> "P";
                    case 2 -> "M";
                    case 3 -> "G";
                    default -> throw new IllegalArgumentException("Opção inválida");
                };

                pizza = new PizzaCalabresa(tamanho);
            }

            unidadeEscolhida.getPedidos().adicionarPedido(pizza);

            System.out.print("\nO seu pedido foi realizado com sucesso!\nInformações do pedido: ");
            System.out.println(pizza);

            pizza.preparar();
            pizza.levarAoForno();
            pizza.entregar();

            System.out.print(
                    """
                    
                    -------------------------------
                    Deseja pedir mais alguma coisa?
                    -------------------------------
                    1 - Sim
                    2 - Não
                    
                    """);

            System.out.print("Sua escolha: ");
            int continua = Integer.parseInt(input.readLine());

            if (continua == 1) {
                menu();
            } else {
                return;
            }

        } else {
            System.out.println("\nDesculpe... A unidade selecionada se encontra fechada nesse momento.");
            menu();
        }
    }

}
