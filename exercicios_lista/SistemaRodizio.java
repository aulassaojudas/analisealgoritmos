// Classe que representa um nó da lista circular
class NoCircular {
    int valor;
    NoCircular proximo;  // Referência para o próximo nó

    public NoCircular(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

// Classe que representa a lista circular
class ListaCircular {
    private NoCircular cabeca;
    private NoCircular cauda;  // Mantém referência para o último nó

    public ListaCircular() {
        this.cabeca = null;
        this.cauda = null;
    }

    // Adicionar um novo nó (veículo) ao final da lista
    public void adicionar(int valor) {
        NoCircular novoNo = new NoCircular(valor);

        // Se a lista estiver vazia, o novo nó será a cabeça e a cauda
        if (cabeca == null) {
            cabeca = cauda = novoNo;
            cauda.proximo = cabeca;  // Conecta o último nó de volta ao primeiro
        } else {
            cauda.proximo = novoNo;
            cauda = novoNo;
            cauda.proximo = cabeca;  // Atualiza a cauda para apontar para a cabeça
        }
    }

    // Exibir os elementos da lista circular
    public void listar() {
        if (cabeca == null) return;

        NoCircular temp = cabeca;
        do {
            System.out.print(temp.valor + " -> ");
            temp = temp.proximo;
        } while (temp != cabeca);  // Continuar até voltar à cabeça
        System.out.println("(volta ao início)");
    }
}

// Classe principal para testar a lista circular
public class SistemaRodizio {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        // Adicionar veículos (números inteiros)
        lista.adicionar(101);
        lista.adicionar(102);
        lista.adicionar(103);

        // Listar os veículos
        lista.listar();
    }
}