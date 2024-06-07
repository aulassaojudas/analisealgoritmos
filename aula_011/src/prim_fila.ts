import { Grafo } from './Graph';

const g = new Grafo(5);
g.adicionarAresta(0, 1, 2);
g.adicionarAresta(0, 3, 6);
g.adicionarAresta(1, 2, 3);
g.adicionarAresta(1, 3, 8);
g.adicionarAresta(1, 4, 5);
g.adicionarAresta(2, 4, 7);
g.adicionarAresta(3, 4, 9);

g.primMST();
