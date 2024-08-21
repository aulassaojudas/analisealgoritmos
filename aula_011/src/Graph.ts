import { MinHeap } from "./MinHeap";

export class Grafo {
  private vertices: number;
  private listaAdj: Map<number, [number, number][]>;

  constructor(vertices: number) {
    this.vertices = vertices;
    this.listaAdj = new Map();
    for (let i = 0; i < vertices; i++) {
      this.listaAdj.set(i, []);
    }
  }

  adicionarAresta(u: number, v: number, peso: number) {
    this.listaAdj.get(u)?.push([v, peso]);
    this.listaAdj.get(v)?.push([u, peso]);
  }

  primMST() {
    const chave: number[] = Array(this.vertices).fill(Infinity);
    const pai: number[] = Array(this.vertices).fill(-1);
    const noMST: boolean[] = Array(this.vertices).fill(false);

    const minHeap = new MinHeap();
    chave[0] = 0;
    minHeap.inserir(0, 0);

    while (!minHeap.estaVazio()) {
      const [u, _] = minHeap.extrairMin()!;
      noMST[u] = true;

      const vizinhos = this.listaAdj.get(u) || [];
      for (const [v, peso] of vizinhos) {
        if (!noMST[v] && peso < chave[v]) {
          chave[v] = peso;
          pai[v] = u;
          minHeap.inserir(v, chave[v]);
        }
      }
    }

    this.imprimirMST(pai);
  }

  private imprimirMST(pai: number[]) {
    console.log("Aresta \tPeso");
    for (let i = 1; i < this.vertices; i++) {
      console.log(
        `${pai[i]} - ${i} \t${
          this.listaAdj.get(i)?.find((aresta) => aresta[0] === pai[i])?.[1]
        }`
      );
    }
  }
}
