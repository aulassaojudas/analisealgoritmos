// Classe que representa um nó da lista encadeada
class No {
    int valor;    // Valor do nó
    No proximo;   // Referência para o próximo nó

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

// Classe que representa a lista encadeada
class ListaEncadeada {
    private No cabeca;  // Referência para o primeiro nó da lista

    public ListaEncadeada() {
        this.cabeca = null;
    }

    // Adicionar um novo nó (pedido) ao final da lista
    public void adicionar(int valor) {
        No novoNo = new No(valor);  // Cria um novo nó

        // Se a lista estiver vazia, o novo nó será a cabeça (primeiro nó)
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No temp = cabeca;
            // Percorre até o último nó
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            // Adiciona o novo nó no final
            temp.proximo = novoNo;
        }
    }

    // Exibir todos os elementos da lista
    public void listar() {
        No temp = cabeca;
        while (temp != null) {
            System.out.print(temp.valor + " -> ");
            temp = temp.proximo;
        }
        System.out.println("null");  // Indica o fim da lista
    }
}

// Classe principal para testar a lista encadeada
public class SistemaPedidos {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        // Adicionar pedidos (números inteiros)
        lista.adicionar(101);
        lista.adicionar(102);
        lista.adicionar(103);

        // Listar os pedidos
        System.out.println("Lista de pedidos:");
        lista.listar();
    }
}