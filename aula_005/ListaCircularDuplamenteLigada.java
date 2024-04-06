/*
 O código implementa uma lista circular duplamente ligada

### Classe `No`

#### Atributos:
- `dado`    : O valor armazenado no nó.
- `anterior`: Referência ao nó anterior na lista.
- `proximo` : Referência ao próximo nó na lista.

#### Construtor:
- `No(int dado)`: Inicializa o nó com o valor fornecido e deixa as referências `anterior` e `proximo` como `null`.

### Classe `ListaCircularDuplamenteLigada`

#### Atributos:
- `cabeca`: Referência ao primeiro nó da lista.
- `cauda` : Referência ao último nó da lista.

#### Métodos:

  - `inserir(int dado)`: Adiciona um novo nó ao final da lista:
  - `remover(int dado)`: Remove um nó que contém o valor especificado:
  - `imprimirDireto()` : Imprime todos os dados dos nós na ordem direta, começando da `cabeca` e seguindo os nós `proximo`.
  - `imprimirInverso()`: Imprime todos os dados dos nós na ordem inversa, começando da `cauda` e seguindo os nós `anterior`.

 */
class No {
    int dado;
    No anterior;
    No proximo;

    public No(int dado) {
        this.dado = dado;
    }
}

class ListaCircularDuplamenteLigada {
    private No cabeca = null;
    private No cauda = null;

    // Inserir no fim da lista
    public void inserir(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
            novoNo.anterior = novoNo;
            novoNo.proximo = novoNo;
        } else {
            novoNo.anterior = cauda;
            novoNo.proximo = cabeca;
            cauda.proximo = novoNo;
            cabeca.anterior = novoNo;
            cauda = novoNo;
        }
    }

    // Remover um nó com o dado especificado da lista
    public boolean remover(int dado) {
        if (cabeca == null) {
            return false;
        }

        No atual = cabeca;
        do {
            if (atual.dado == dado) {
                if (atual == cabeca && atual == cauda) {
                    cabeca = null;
                    cauda = null;
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;

                    if (atual == cabeca) {
                        cabeca = atual.proximo;
                    } else if (atual == cauda) {
                        cauda = atual.anterior;
                    }
                }
                return true;
            }
            atual = atual.proximo;
        } while (atual != cabeca);

        return false;
    }

    // Imprimir a lista do início ao fim
    public void imprimirDireto() {
        if (cabeca != null) {
            No atual = cabeca;
            do {
                System.out.print(atual.dado + " <-> ");
                atual = atual.proximo;
            } while (atual != cabeca);
            System.out.println();
        } else {
            System.out.println("A lista está vazia.");
        }
    }

    // Imprimir a lista do fim ao início
    public void imprimirInverso() {
        if (cauda != null) {
            No atual = cauda;
            do {
                System.out.print(atual.dado + " <-> ");
                atual = atual.anterior;
            } while (atual != cauda);
            System.out.println();
        } else {
            System.out.println("A lista está vazia.");
        }
    }

    public static void main(String[] args) {
        ListaCircularDuplamenteLigada lista = new ListaCircularDuplamenteLigada();
        
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);

        System.out.println("Lista Circular Duplamente Ligada (Direto):");
        lista.imprimirDireto();

        System.out.println("Lista Circular Duplamente Ligada (Inverso):");
        lista.imprimirInverso();

        if (lista.remover(2)) {
            System.out.println("Após remover o valor 2:");
            lista.imprimirDireto();
        } else {
            System.out.println("Valor 2 não encontrado para remoção.");
        }
    }
}
