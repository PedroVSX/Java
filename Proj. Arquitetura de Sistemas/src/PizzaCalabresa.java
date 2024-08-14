public class PizzaCalabresa extends Pizza {

    public PizzaCalabresa(String tamanho) {
        super(tamanho);
    }

    @Override
    protected double calcularPreco(String tamanho) {
        switch (tamanho) {
            case "P" -> {
                return 25.0;
            }
            case "M" -> {
                return 35.0;
            }
            case "G" -> {
                return 50.0;
            }

            default -> throw new IllegalArgumentException("Tamanho inválido!");
        }
    }

    @Override
    public void preparar() {
        System.out.println("Preparando pizza de calabresa...");
    }

    @Override
    public void levarAoForno() {
        System.out.println("Esquentando pizza de calabresa...");
    }

    @Override
    public void entregar() {
        System.out.println("Pizza de calabresa entregue!");
    }

    @Override
    public String toString() {
        return  "Pizza de Calabresa\n" +
                "Tamanho: " + super.tamanho + "\n" +
                "Preço: R$" + super.preco;
    }
}
