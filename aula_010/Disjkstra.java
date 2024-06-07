import java.util.*;

public class Disjkstra {
    static class Node implements Comparable<Node> {
        String name;
        int distance;

        Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static Map<String, Integer> disjkstra(Map<String, Map<String, Integer>> graph, String start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        Map<String, Integer> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for( String node: graph.keySet()){
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        pq.add(new Node(start, 0)); 

        while (!pq.isEmpty()) {
            Node current = pq.poll(); 
            if(!visited.add(current.name)) continue; 
            for( Map.Entry<String, Integer> neighbor: graph.get(current.name).entrySet()){
                int newDist = current.distance + neighbor.getValue();
                if( newDist < distances.get(neighbor.getKey())){
                    distances.put(neighbor.getKey(), newDist);
                    pq.add(new Node(neighbor.getKey(), newDist));
                }
            }
        }
        return distances; 
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>(); 
        graph.put("A", Map.of("B", 4, "C", 2) ); 
        graph.put("B", Map.of("A", 4, "C",1 , "D",5));
        graph.put("C", Map.of("A", 2, "B",1 , "D",8, "E", 10));
        graph.put("D", Map.of("B", 5, "C",8 , "E",2));
        graph.put("E", Map.of("C", 10, "D",2 ));

        String inicio = "B"; 

        Map<String, Integer> distances = disjkstra(graph, inicio); 

        System.out.println("Distâncias a partir do nó " + inicio);
        for(Map.Entry<String, Integer> entry: distances.entrySet()){
            String dist = entry.getValue() == Integer.MAX_VALUE ? "∞" : entry.getValue().toString();
            System.out.println("Nó " + entry.getKey() + ": " + dist); 
        }
    }
}