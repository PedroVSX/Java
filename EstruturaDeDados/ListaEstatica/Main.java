package ListaEstatica;

public class Main {

    public static void main(String[] args) {

        ListaEstatica lista = new ListaEstatica();

        lista.add(1);
        lista.add(2);
        lista.add("Bom dia");
        lista.add(3);
        lista.show();

        lista.add(4,"Oi");
        lista.show();

        lista.remove("Bom dia");
        lista.show();

        lista.remove(4);
        lista.show();

        System.out.println(lista.indexOf(3));

        System.out.println(lista.contains(2));

        System.out.println(lista.size());

        lista.clear();
        lista.show();

    }

}
