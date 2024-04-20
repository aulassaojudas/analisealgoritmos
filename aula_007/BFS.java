import java.util.*;

public class BFS {

    // Método para realizar a busca em largura no grafo
    public static void bfs(int start, List<List<Integer>> graph) {
        // Array para manter controle dos vértices visitados
        boolean[] visited = new boolean[graph.size()];
        // Fila para ajudar na busca em largura
        Queue<Integer> queue = new LinkedList<>();

        // Inicia a busca pelo vértice start
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.println("Visitando o vértice: " + vertex);
            
            // Iterar sobre todos os vértices adjacentes ao atual
            for (int adjacent : graph.get(vertex)) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Criando um grafo como exemplo
        List<List<Integer>> graph = new ArrayList<>();
        
        // Suponha que temos 5 vértices no grafo (0 a 4)
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }

        // Adicionando arestas - Exemplo de um grafo não direcionado
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);

        // Chamada do BFS a partir do vértice 0
        bfs(0, graph);
    }
}
