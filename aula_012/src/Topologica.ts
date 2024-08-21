class Graph {
    private adjList: Map<number, number[]>;
    private indegree: number[];
    private vertices: number;

    constructor(vertices: number) {
        this.vertices = vertices;
        this.adjList = new Map();
        this.indegree = new Array(vertices).fill(0);

        for (let i = 0; i < vertices; i++) {
            this.adjList.set(i, []);
        }
    }

    addEdge(u: number, v: number) {
        this.adjList.get(u)!.push(v);
        this.indegree[v]++;
    }

    topologicalSort() {
        const queue: number[] = [];
        const topOrder: number[] = [];

        for (let i = 0; i < this.vertices; i++) {
            if (this.indegree[i] === 0) {
                queue.push(i);
            }
        }

        let count = 0;

        while (queue.length > 0) {
            const u = queue.shift()!;
            topOrder.push(u);

            this.adjList.get(u)!.forEach(v => {
                this.indegree[v]--;
                if (this.indegree[v] === 0) {
                    queue.push(v);
                }
            });

            count++;
        }

        if (count !== this.vertices) {
            console.log("Ciclo detectado no grafo. Ordenação topológica não é possível.");
            return;
        }

        console.log("Ordenação Topológica: ", topOrder.join(" "));
    }
}

// Exemplo de uso
const g = new Graph(6);
g.addEdge(5, 2);
g.addEdge(5, 0);
g.addEdge(4, 0);
g.addEdge(4, 1);
g.addEdge(2, 3);
g.addEdge(3, 1);

g.topologicalSort();
