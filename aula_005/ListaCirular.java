/*
 O código implementa uma lista circular.

### Classe `No`
Esta classe interna representa um nó da lista, com os seguintes dados
- `dado`   : O valor armazenado no nó.
- `proximo`: Uma referência ao próximo nó na lista.

#### Construtor
- `No(int dado)`: Configura o `dado` do nó e inicializa `proximo` como `null`.

### Classe `ListaCircular`
Esta classe gerencia a lista circular.

#### Atributos
- `cabeca`: Uma referência ao primeiro nó na lista.
- `cauda` : Uma referência ao último nó na lista.

#### Métodos
- `inserir(int dado)` : Adiciona um novo nó com o valor especificado ao final da lista.
- `remover(int chave)`: Remove o nó que contém o valor especificado (`chave`).
- `imprimirLista()`   : Imprime todos os elementos da lista em um formato circular. 

 */
class ListaCircular {
    class No {
        int dado;
        No proximo;
    
        public No(int dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    private No cabeca = null;
    private No cauda = null;

    public void inserir(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            cauda.proximo = novoNo;
        }
        cauda = novoNo;
        cauda.proximo = cabeca;
    }

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
        return false;
    }

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
