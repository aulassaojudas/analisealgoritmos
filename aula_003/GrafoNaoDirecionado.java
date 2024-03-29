public class GrafoNaoDirecionado {
    private int[][] matrizAdjacencia;
    private int numVertices;

    public GrafoNaoDirecionado(int numVertices) {
        this.numVertices = numVertices;
        matrizAdjacencia = new int[numVertices][numVertices];
    }

    public void adicionarAresta(int v1, int v2) {
        matrizAdjacencia[v1][v2] = 1;
        matrizAdjacencia[v2][v1] = 1;
    }

    public void adicionarSelfLoop(int v) {
        matrizAdjacencia[v][v] = 1;
    }

    public void removerAresta(int v1, int v2) {
        matrizAdjacencia[v1][v2] = 0;
        matrizAdjacencia[v2][v1] = 0;
    }

    public boolean existeAresta(int v1, int v2) {
        return matrizAdjacencia[v1][v2] == 1;
    }

    public void imprimirMatrizAdjacencia() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafoNaoDirecionado grafo = new GrafoNaoDirecionado(5);
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);

        if (grafo.existeAresta(0, 1)) {
            System.out.println("aresta já cadastrada");
        } else {
            System.out.println("aresta não encontrada");
        }

        System.out.println("Matriz de adjacencia");
        grafo.imprimirMatrizAdjacencia();

    }

}