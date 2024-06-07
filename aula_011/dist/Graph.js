"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Grafo = void 0;
const MinHeap_1 = require("./MinHeap");
class Grafo {
    constructor(vertices) {
        this.vertices = vertices;
        this.listaAdj = new Map();
        for (let i = 0; i < vertices; i++) {
            this.listaAdj.set(i, []);
        }
    }
    adicionarAresta(u, v, peso) {
        var _a, _b;
        (_a = this.listaAdj.get(u)) === null || _a === void 0 ? void 0 : _a.push([v, peso]);
        (_b = this.listaAdj.get(v)) === null || _b === void 0 ? void 0 : _b.push([u, peso]);
    }
    primMST() {
        const chave = Array(this.vertices).fill(Infinity);
        const pai = Array(this.vertices).fill(-1);
        const noMST = Array(this.vertices).fill(false);
        const minHeap = new MinHeap_1.MinHeap();
        chave[0] = 0;
        minHeap.inserir(0, 0);
        while (!minHeap.estaVazio()) {
            const [u, _] = minHeap.extrairMin();
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
    imprimirMST(pai) {
        var _a, _b;
        console.log("Aresta \tPeso");
        for (let i = 1; i < this.vertices; i++) {
            console.log(`${pai[i]} - ${i} \t${(_b = (_a = this.listaAdj.get(i)) === null || _a === void 0 ? void 0 : _a.find(aresta => aresta[0] === pai[i])) === null || _b === void 0 ? void 0 : _b[1]}`);
        }
    }
}
exports.Grafo = Grafo;
