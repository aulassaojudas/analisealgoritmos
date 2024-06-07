"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.MinHeap = void 0;
class MinHeap {
    constructor() {
        this.heap = [];
    }
    inserir(no, peso) {
        this.heap.push([no, peso]);
        this.subirBolha();
    }
    extrairMin() {
        if (this.heap.length === 0) {
            return undefined;
        }
        const min = this.heap[0];
        const fim = this.heap.pop();
        if (this.heap.length > 0 && fim !== undefined) {
            this.heap[0] = fim;
            this.afundar();
        }
        return min;
    }
    subirBolha() {
        let idx = this.heap.length - 1;
        const elemento = this.heap[idx];
        while (idx > 0) {
            const idxPai = Math.floor((idx - 1) / 2);
            const pai = this.heap[idxPai];
            if (elemento[1] >= pai[1])
                break;
            this.heap[idxPai] = elemento;
            this.heap[idx] = pai;
            idx = idxPai;
        }
    }
    afundar() {
        let idx = 0;
        const comprimento = this.heap.length;
        const elemento = this.heap[0];
        while (true) {
            const idxFilhoEsquerdo = 2 * idx + 1;
            const idxFilhoDireito = 2 * idx + 2;
            let filhoEsquerdo;
            let filhoDireito;
            let troca = null;
            if (idxFilhoEsquerdo < comprimento) {
                filhoEsquerdo = this.heap[idxFilhoEsquerdo];
                if (filhoEsquerdo[1] < elemento[1]) {
                    troca = idxFilhoEsquerdo;
                }
            }
            if (idxFilhoDireito < comprimento) {
                filhoDireito = this.heap[idxFilhoDireito];
                if ((troca === null && filhoDireito[1] < elemento[1]) ||
                    (troca !== null && filhoDireito !== undefined && filhoEsquerdo !== undefined && filhoDireito[1] < filhoEsquerdo[1])) {
                    troca = idxFilhoDireito;
                }
            }
            if (troca === null)
                break;
            this.heap[idx] = this.heap[troca];
            this.heap[troca] = elemento;
            idx = troca;
        }
    }
    estaVazio() {
        return this.heap.length === 0;
    }
}
exports.MinHeap = MinHeap;
