public class ContaPoupanca extends Conta {

    @Override
    public void processarPagamento(double valor) {
        if (valor > 1000) {
            throw new IllegalArgumentException("O valor do pagamento excede o limite de R$1000,00!");
        }

        System.out.println("Pagamento de R$" + valor + " foi realizado na Conta Poupança.");
    }

}
