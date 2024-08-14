public class PizzaMussarela extends Pizza {

    public PizzaMussarela(String tamanho) {
        super(tamanho);
    }

    @Override
    protected double calcularPreco(String tamanho) {
        switch (tamanho) {
            case "P" -> {
                return 20.0;
            }
            case "M" -> {
                return 30.0;
            }
            case "G" -> {
                return 45.0;
            }

            default -> throw new IllegalArgumentException("Tamanho inválido!");
        }
    }

    @Override
    public void preparar() {
        System.out.println("Preparando pizza de mussarela...");
    }

    @Override
    public void levarAoForno() {
        System.out.println("Esquentando pizza de mussarela...");
    }

    @Override
    public void entregar() {
        System.out.println("Pizza de mussarela entregue!");
    }

    @Override
    public String toString() {
        return  "Pizza de Mussarela\n" +
                "Tamanho: " + super.tamanho + "\n" +
                "Preço: R$" + super.preco;
    }
}
