public abstract class Pizza {

    protected String tamanho;
    protected double preco;

    public Pizza(String tamanho) {
        this.tamanho = tamanho;
        this.preco = calcularPreco(tamanho);
    }

    protected abstract double calcularPreco(String tamanho);

    public void preparar() {
        System.out.println("Preparando pizza...");
    }

    public void levarAoForno() {
        System.out.println("Esquentando pizza...");
    }

    public void entregar() {
        System.out.println("Pizza entregue!");
    }
}
