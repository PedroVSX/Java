package ListaDinamica;

public class Main {
    public static void main(String[] args) {

        ListaDinamica lista = new ListaDinamica();

        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        lista.show();

        lista.remove(0);
        lista.show();

        System.out.println(lista.get(2));

        System.out.println(lista.contains(3));

        lista.clear();
        lista.show();

    }
}
