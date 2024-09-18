// Classe que representa um nó da lista duplamente encadeada
class NoDuplo {
    int valor;         // Valor do nó
    NoDuplo anterior;  // Referência para o nó anterior
    NoDuplo proximo;   // Referência para o próximo nó

    public NoDuplo(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

// Classe que representa a lista duplamente encadeada
class ListaDuplamenteEncadeada {
    private NoDuplo cabeca;
    private NoDuplo cauda;  // Adiciona referência para o último nó

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
    }

    // Adicionar um novo nó (livro) ao final da lista
    public void adicionar(int valor) {
        NoDuplo novoNo = new NoDuplo(valor);

        // Se a lista estiver vazia, o novo nó será a cabeça e a cauda
        if (cabeca == null) {
            cabeca = cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            novoNo.anterior = cauda;
            cauda = novoNo;  // Atualiza a cauda
        }
    }

    // Exibir os elementos da lista da esquerda para a direita
    public void listarDirecaoNormal() {
        NoDuplo temp = cabeca;
        System.out.println("Lista na ordem normal:");
        while (temp != null) {
            System.out.print(temp.valor + " -> ");
            temp = temp.proximo;
        }
        System.out.println("null");
    }

    // Exibir os elementos da lista da direita para a esquerda
    public void listarDirecaoInversa() {
        NoDuplo temp = cauda;
        System.out.println("Lista na ordem inversa:");
        while (temp != null) {
            System.out.print(temp.valor + " -> ");
            temp = temp.anterior;
        }
        System.out.println("null");
    }
}

// Classe principal para testar a lista duplamente encadeada
public class SistemaBiblioteca {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        // Adicionar livros (números inteiros)
        lista.adicionar(101);
        lista.adicionar(102);
        lista.adicionar(103);

        // Listar os livros na ordem normal
        lista.listarDirecaoNormal();

        // Listar os livros na ordem inversa
        lista.listarDirecaoInversa();
    }
}