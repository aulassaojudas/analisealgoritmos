import java.util.ArrayList;
import java.util.List;

public class ListaSimplesArrayListItem {
    public static void main(String[] args) {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(20, "jose"));
        itens.add(new Item(10, "maria"));
        itens.add(new Item(5, "eduardo"));

        System.out.println("lista " + itens);
        System.out.println("lista " + itens.get(0));

        itens.removeIf(item -> "maria".equals(item.getNome()));

        System.out.println("lista despois da remocao da maria " + itens);

        boolean contem = itens.stream().anyMatch(item -> item.getValor() == 20);
        System.out.println("sera que o valor 20 esta na lista " + contem);

    }
}

class Item {
    private int valor;
    private String nome;

    public Item(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public int getValor() {
        return this.valor;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Item{ " + "Valor=" + this.valor + ", nome=" + this.nome + "}";
    }

}