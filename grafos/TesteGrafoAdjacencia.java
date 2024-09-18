/*
 * Imagine que você está modelando o sistema de rotas de uma cidade, onde os cruzamentos são os vértices e as
 *  ruas são as arestas. Queremos saber quais cruzamentos estão conectados diretamente uns aos outros. 
 * Usaremos uma matriz de adjacência para representar essas conexões.
 */
// Implementação de Grafo usando Matriz de Adjacência
class GrafoAdjacencia {
    private int[][] matrizAdjacencia;
    private int numVertices;

    // Construtor para inicializar o grafo com N vértices
    public GrafoAdjacencia(int numVertices) {
        this.numVertices = numVertices;
        matrizAdjacencia = new int[numVertices][numVertices];  // Inicializa a matriz de adjacência com zeros
    }

    // Método para adicionar uma aresta entre dois vértices
    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = 1;  // Aresta de origem a destino
        matrizAdjacencia[destino][origem] = 1;  // Para grafos não direcionados, adicionamos também de destino a origem
    }

    // Método para remover uma aresta entre dois vértices
    public void removerAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = 0;
        matrizAdjacencia[destino][origem] = 0;
    }

    // Método para exibir a matriz de adjacência
    public void exibirMatriz() {
        System.out.println("Matriz de Adjacência:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Classe principal para testar a matriz de adjacência
public class TesteGrafoAdjacencia {
    public static void main(String[] args) {
        // Criar um grafo com 4 vértices
        GrafoAdjacencia grafo = new GrafoAdjacencia(4);

        // Adicionar arestas
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);

        // Exibir a matriz de adjacência
        grafo.exibirMatriz();
    }
}
