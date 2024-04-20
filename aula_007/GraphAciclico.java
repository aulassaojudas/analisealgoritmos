/*
 *
 * O `GraphAciclico` que é utilizdo para criar e analisar grafos em busca de ciclos. 
 * A classe armazena o grafo como uma lista de adjacências (`adjLists`), e usa arrays (`visited` e `recStack`) 
 * para marcar vértices já visitados e para manter uma pilha de chamadas recursivas, respectivamente. 
 * Um `Stack<Integer>` (`pathStack`) é usado para rastrear o caminho atual na busca em profundidade (DFS). 
 * O método `addEdge` adiciona direções aos vértices, 
 * enquanto `isCyclicUtil` realiza a DFS, identificando e armazenando ciclos encontrados em `cycles`, uma lista de listas de inteiros.
 * A funcionalidade principal é verificar se o grafo é acíclico através do método `isAcyclic`, 
 * que retorna verdadeiro se nenhum ciclo for encontrado.
 * O método `printCycles` imprime todos os ciclos detectados, se houver. 
 * O método `main` exemplifica o uso da classe com dois testes: um em um grafo acíclico e outro em um grafo que contém ciclos, 
 * demonstrando como a classe pode ser utilizada para detectar e reportar a presença de ciclos em grafos.
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphAciclico {
    private List<List<Integer>> adjLists;
    private boolean[] visited;
    private boolean[] recStack;
    private List<List<Integer>> cycles;
    private Stack<Integer> pathStack;

    public GraphAciclico(int vertices) {
        adjLists = new ArrayList<>(vertices);
        visited = new boolean[vertices];
        recStack = new boolean[vertices];
        cycles = new ArrayList<>();
        pathStack = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            adjLists.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjLists.get(src).add(dest);
    }

    private void isCyclicUtil(int vertex) {
        visited[vertex] = true;
        recStack[vertex] = true;
        pathStack.push(vertex);

        for (Integer child : adjLists.get(vertex)) {
            if (!visited[child]) {
                isCyclicUtil(child);
            } else if (recStack[child]) {
                // Encontrou um ciclo, captura os vértices do ciclo
                int cycleStartIdx = pathStack.indexOf(child);
                if (cycleStartIdx != -1) {
                    List<Integer> cycle = new ArrayList<>();
                    for (int i = cycleStartIdx; i < pathStack.size(); i++) {
                        cycle.add(pathStack.get(i));
                    }
                    cycle.add(child); // Adicionar o vértice inicial para fechar o ciclo
                    cycles.add(cycle);
                }
            }
        }

        pathStack.pop();
        recStack[vertex] = false;
    }

    public boolean isAcyclic() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                isCyclicUtil(i);
            }
        }
        return cycles.isEmpty();
    }

    public void printCycles() {
        if (cycles.isEmpty()) {
            System.out.println("Nenhum ciclo encontrado.");
        } else {
            System.out.println("Ciclos encontrados (" + cycles.size() + "):");
            for (List<Integer> cycle : cycles) {
                System.out.println(cycle);
            }
        }
    }

    public static void main(String[] args) {
        // Testando um grafo acíclico
        GraphAciclico graphAciclico = new GraphAciclico(4);
        graphAciclico.addEdge(0, 1);
        graphAciclico.addEdge(1, 2);
        graphAciclico.addEdge(2, 3);
        System.out.println("Teste com Grafo Acíclico:");
        graphAciclico.isAcyclic();
        graphAciclico.printCycles(); // Esperado: Nenhum ciclo encontrado.

        // Testando um grafo com ciclos
        GraphAciclico graphCiclico = new GraphAciclico(4);
        graphCiclico.addEdge(0, 1);
        graphCiclico.addEdge(1, 2);
        graphCiclico.addEdge(2, 3);
        graphCiclico.addEdge(3, 1); // Adiciona um ciclo
        System.out.println("Teste com Grafo Ciclico:");
        graphCiclico.isAcyclic();
        graphCiclico.printCycles(); // Esperado: Ciclos encontrados.
    }
}
