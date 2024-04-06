
public class ListaLigadaSimples {
    private static class No {
        int dado; 
        No proximo; 

        No(int dado ){
            this.dado = dado; 
            this.proximo = null; 
        }
    }

    private No cabeca; 

    public ListaLigadaSimples() {
        this.cabeca = null; 
    }

    public void inserirInicio( int novoDado ){
        No novoNo = new No( novoDado );
        novoNo.proximo = this.cabeca; 
        cabeca = novoNo; 
    }

    public boolean remover(int dado) {
        No atual = this.cabeca; 
        No anterior = null; 
        while( atual != null && atual.dado != dado ){
            anterior = atual; 
            atual = atual.proximo; 
        }

        if( atual == null ){
            return false; 
        } 
        
        if(anterior != null ){
            anterior.proximo = atual.proximo; 
        } else {
            this.cabeca = atual.proximo;
        }
        return true; 
    }

    public No buscar(int dado){
        No atual = this.cabeca; 
        while(atual != null ){
            if( atual.dado == dado) {
                return atual; 
            }
            atual = atual.proximo; 
        }
        return atual; 
    }

    public void travessia(){ 
        No atual = cabeca; 
        while (atual != null ) {
            System.out.print(atual.dado + " -> ");
            atual = atual.proximo; 
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaLigadaSimples lista = new ListaLigadaSimples();

        lista.inserirInicio(3);
        lista.inserirInicio(2);
        lista.inserirInicio(1);

        lista.travessia();

        if(lista.remover(2)){
            System.out.println("foi removido o nó ");
        } else {
            System.out.println("nó não encontrado");
        }

        lista.travessia();

        No noEncontrado = lista.buscar(1);
        if(noEncontrado != null){
            System.out.println("nó encontrado");
        } else {
            System.out.println("nó não encontrado");
        }
    }
}
