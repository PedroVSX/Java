public class ContaCorrente extends Conta {

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " foi realizado na Conta Corrente.");
    }

}