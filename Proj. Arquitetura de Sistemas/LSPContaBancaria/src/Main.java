public class Main {

    public static void main(String[] args) {
        Conta contaC = new ContaCorrente();
        Conta contaP = new ContaPoupanca();

        ProcessadorDePagamentos processador = new ProcessadorDePagamentos();

        processador.processar(contaC, 2000);

        processador.processar(contaP, 1000);

        try {
            processador.processar(contaP, 2500);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
