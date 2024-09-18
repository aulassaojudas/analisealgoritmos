/*
 * Agora, imagine que você está modelando o sistema de distribuição de energia de uma cidade. 
 * Cada vértice representa uma subestação, e cada aresta é uma linha de transmissão. Você deseja representar quais vértices 
 * (subestações) são conectados por quais arestas (linhas de transmissão). Usaremos uma matriz de incidência para isso.
 */
// Implementação de Grafo usando Matriz de Incidência
class GrafoIncidencia {
    private int[][] matrizIncidencia;
    private int numVertices;
    private int numArestas;
    private int arestaAtual;

    // Construtor para inicializar o grafo com N vértices e M arestas
    public GrafoIncidencia(int numVertices, int numArestas) {
        this.numVertices = numVertices;
        this.numArestas = numArestas;
        matrizIncidencia = new int[numVertices][numArestas];  // Inicializa a matriz de incidência com zeros
        this.arestaAtual = 0;  // Controla o número de arestas adicionadas
    }

    // Método para adicionar uma aresta entre dois vértices
    public void adicionarAresta(int origem, int destino) {
        if (arestaAtual < numArestas) {
            matrizIncidencia[origem][arestaAtual] = 1;
            matrizIncidencia[destino][arestaAtual] = 1;
            arestaAtual++;
        } else {
            System.out.println("Limite de arestas atingido.");
        }
    }

    // Método para exibir a matriz de incidência
    public void exibirMatriz() {
        System.out.println("Matriz de Incidência:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numArestas; j++) {
                System.out.print(matrizIncidencia[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Classe principal para testar a matriz de incidência
public class TesteGrafoIncidencia {
    public static void main(String[] args) {
        // Criar um grafo com 4 vértices e 4 arestas
        GrafoIncidencia grafo = new GrafoIncidencia(4, 4);

        // Adicionar arestas
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);

        // Exibir a matriz de incidência
        grafo.exibirMatriz();
    }
}
