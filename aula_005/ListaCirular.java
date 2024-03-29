
class No {
    int dado;
    No proximo;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class ListaCircular {
    private No cabeca = null;
    private No cauda = null;

    // Inserir no fim da lista
    public void inserir(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            cauda.proximo = novoNo;
        }
        cauda = novoNo;
        cauda.proximo = cabeca; // Faz o último nó apontar para o cabeça, formando um círculo
    }

    // Remover um elemento da lista
    public boolean remover(int chave) {
        if (cabeca == null) {
            return false;
        }
        No atual = cabeca;
        No anterior = null;
        do {
            if (atual.dado == chave) {
                if (atual == cabeca) {
                    cauda.proximo = cabeca.proximo;
                    cabeca = cabeca.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                if (atual == cauda) {
                    cauda = anterior;
                }
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        } while (atual != cabeca);
        return false; // Elemento para remover não foi encontrado
    }

    // Imprimir a lista
    public void imprimirLista() {
        if (cabeca != null) {
            No atual = cabeca;
            do {
                System.out.print(atual.dado + " -> ");
                atual = atual.proximo;
            } while (atual != cabeca);
            System.out.println("(" + cabeca.dado + " no início da lista)");
        } else {
            System.out.println("Lista está vazia.");
        }
    }

    public static void main(String[] args) {
        ListaCircular listaCircular = new ListaCircular();

        listaCircular.inserir(1);
        listaCircular.inserir(2);
        listaCircular.inserir(3);

        System.out.println("Lista Circular:");
        listaCircular.imprimirLista();

        System.out.println("\nApós remover o elemento '2':");
        listaCircular.remover(2);
        listaCircular.imprimirLista();
    }
}
