import java.util.*;

public class Graph {
    private List<List<Integer>> adjLists; // Lista de adjacências usando uma lista de listas
    private boolean[] visited; // Array para controlar os nós visitados

    // Construtor do grafo
    Graph(int vertices) {
        adjLists = new ArrayList<>(vertices);
        visited = new boolean[vertices];

        // Inicializa as listas de adjacência para cada vértice
        for (int i = 0; i < vertices; i++) {
            adjLists.add(new LinkedList<Integer>());
        }
    }

    // Adicionar uma aresta ao grafo
    void addEdge(int src, int dest) {
        adjLists.get(src).add(dest);
    }

    // Uma função de utilidade que faz a DFS a partir de um vértice dado
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " "); // Imprime o vértice visitado

        List<Integer> vizinho = adjLists.get(vertex);
        for (int adj : vizinho) {
            if (!visited[adj]) {
                DFS(adj); // Chamada recursiva sem profundidade
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        // Adicionando arestas
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Realizando a DFS a partir do vértice 2:");
        g.DFS(2); // Inicia a DFS a partir do vértice 2
    }
}
