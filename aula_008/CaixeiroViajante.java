package aula_008;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaixeiroViajante {
    private int[][] distancias; // matriz que representa as distâncias entre as cidades
    
    public CaixeiroViajante(int[][] distancias) {
        this.distancias = distancias;
    }

    // a heuristica é adotar a menor distância entre as cidades
    public List<Integer> encontrarCaminho(int cidadeInicial) {
        int n = distancias.length;
        ArrayList<Integer> caminho = new ArrayList<>();
        boolean[] visitado = new boolean[n];
        Arrays.fill(visitado, false);
        int atual = cidadeInicial;
        visitado[atual] = true;
        caminho.add(atual);
        for (int i = 1; i < n; i++) {
            int cidadeMaisProxima = -1;
            int distanciaMinima = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visitado[j] && distancias[atual][j] < distanciaMinima) {
                    cidadeMaisProxima = j;
                    distanciaMinima = distancias[atual][j];
                }
            }
            caminho.add(cidadeMaisProxima);
            visitado[cidadeMaisProxima] = true;
            atual = cidadeMaisProxima;
        }

        // Retorna ao ponto inicial completando o ciclo 
        caminho.add(cidadeInicial);
        return caminho;
    }

    public static void main(String[] args) {
        // Exemplo de uma matriz de distâncias entre 4 cidades
        int[][] distancias = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        CaixeiroViajante caixeiro = new CaixeiroViajante(distancias);
        List<Integer> caminho = caixeiro.encontrarCaminho(0);
        System.out.println("Caminho encontrado: " + caminho);
    }
}
