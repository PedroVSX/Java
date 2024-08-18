import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    public void iniciar(Pizzaria pizzaria) {
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
        int i = input.nextInt() - 1;
        Unidade unidadeEscolhida = pizzaria.getUnidadeEspecifica(i);

        checarDisponibilidade(pizzaria, unidadeEscolhida);
    }

    public void checarDisponibilidade(Pizzaria pizzaria, Unidade unidadeEscolhida) {
        if (unidadeEscolhida.taDisponivel()) {
            // Pede o sabor
            pedirSabor(unidadeEscolhida);

            System.out.print(
                    """
                    
                    -------------------------------
                    Deseja pedir mais alguma coisa?
                    -------------------------------
                    1 - Sim
                    2 - Não
                    
                    """);

            System.out.print("Sua escolha: ");
            int continua = input.nextInt();

            if (continua == 1) {
                iniciar(pizzaria);
            } else {
                System.out.println(

                        """
                        
                        ------------------------
                        Obrigado! Volte sempre!
                        ------------------------
                        """
                );
                return;
            }

        } else {
            // Chama menu novamente
            System.out.println("\nDesculpe... A unidade selecionada se encontra fechada nesse momento.");
            iniciar(pizzaria);
        }
    }

    public void pedirSabor(Unidade unidadeEscolhida) {
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

        int sabor = input.nextInt();

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

        int tamanhoEscolhido = input.nextInt();
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
        System.out.println(pizza + "\n");

        pizza.preparar();
        pizza.levarAoForno();
        pizza.entregar();
    }

}
