public class FloydWarshal {
    final static double INF = Double.POSITIVE_INFINITY; 
    public static void imprimirMatriz(double[][] matriz){
        for(double[] linha : matriz){
            for(double valor: linha){
                if(valor == INF){
                    System.out.print("INF");
                } else {
                    System.out.printf("%.1f ", valor);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){ 
        double[][] grafo = {
            {0, 4, 2, INF, INF }, 
            {4, 0, 1, 5, INF}, 
            {2, 1, 0, 8, 10}, 
            {INF, 5, 8, 0, 2}, 
            {INF, INF, 10, 2, 0}
        };

        int numVertice = grafo.length;
        double[][] dist = new double[numVertice][numVertice]; 
        double[][][] passos = new double[numVertice +1][ numVertice][numVertice]; 
        String[] atualizacoes = new String[numVertice*numVertice]; 
        int indiceAtualizacao = 0; 

        // inicializa as disntâncias e passos
        for(int i = 0; i < numVertice; i++){
            for(int j = 0; j <numVertice; j++){
                dist[i][j] = grafo[i][j]; 
                passos[0][i][j] = grafo[i][j]; 
            }
        }
        // algoritmo FloydWarshall 
        for( int k = 0; k < numVertice; k ++){
            for( int i =0; i < numVertice; i ++) {
                for( int j =0; j < numVertice; j++){
                    if( dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        atualizacoes[indiceAtualizacao++] = "Atualizado dist[" + i + "]["+ j + "] via" + k; 
                    }
                    passos[k + 1][i][j] = dist[i][j];
                }
            }
        }

        for( int passo = 0; passo <= numVertice; passo++){
            System.out.println("Passo " + passo + ":");
            imprimirMatriz(passos[passo]);
        }
        
        for(int i = 0; i < indiceAtualizacao; i++){
            System.out.println(atualizacoes[i]);
        }
    }
}
