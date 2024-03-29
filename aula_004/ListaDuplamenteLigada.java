class No {
    int dado;
    No anterior;
    No proximo;

    public No(int dado) {
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
}

public class ListaDuplamenteLigada {
    private No cabeca;
    private No cauda;

    public void inserirInicio(int dado) {
        No novoNo = new No(dado);
        novoNo.proximo = cabeca;
        if (cabeca != null) {
            cabeca.anterior = novoNo;
        }
        cabeca = novoNo;
        if (cauda == null) {
            cauda = novoNo;
        }
    }

    public boolean remover(int dado) {
        No atual = this.cabeca;
        while (atual != null) {
            if (atual.dado == dado) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    this.cabeca = atual.proximo;
                }
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    this.cauda = atual.anterior;
                }
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public No buscar(int dado) {
        No atual = this.cabeca;
        while (atual != null) {
            if (atual.dado == dado) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void imprimirDoPrimeiro() {
        No atual = this.cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " -> ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] parametro) {
        ListaDuplamenteLigada lista = new ListaDuplamenteLigada();
        lista.inserirInicio(3);
        lista.inserirInicio(2);
        lista.inserirInicio(1);

        System.out.println("imprimir do primeiro ");
        lista.imprimirDoPrimeiro();
        if (lista.remover(2)) {
            System.out.println("no removido");
        } else {
            System.out.println("no nao encontrado");
        }
        lista.imprimirDoPrimeiro();
        No noEncontrado = lista.buscar(1);
        if (noEncontrado != null) {
            System.out.println("no encontrado");
        } else {
            System.out.println("no nao encontrado");
        }

    }

}
