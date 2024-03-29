public class OperacoesMatrizes {
    
    public static void main(String[] argumento){ 
        int[][] matrizA = { {1, 2}, {3, 4}};
        int[][] matrizB = { {5, 6}, {7, 8}};

        //adição de matrizes 
        int[][] soma = new int[matrizA.length][matrizA.length];
        for( int linha = 0; linha < matrizA.length; linha ++){
            for( int coluna = 0; coluna <matrizA.length; coluna ++){
                soma[linha][coluna] = matrizA[linha][coluna] + matrizB[linha][coluna]; 
            }
        }
        total(soma);

        //subtração de matrizes 
        int[][] subtracao = new int[matrizA.length][matrizA.length];
        for( int linha = 0; linha < matrizA.length; linha ++){ 
            for( int coluna = 0; coluna <matrizA.length; coluna ++){
                subtracao[linha][coluna] = matrizA[linha][coluna] - matrizB[linha][coluna]; 
            }
        }
        total(subtracao);

        //multiplicacao de matrizes 
        int[][] multiplicacao = new int[matrizA.length][matrizA.length];
        for( int i = 0; i < multiplicacao.length; i++){
            for( int j = 0; j <multiplicacao.length; j ++){
                for( int k = 0; k <matrizA.length; k ++){
                    multiplicacao[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

    }

    public static void total( int[][] matrizA ){
        for( int linha = 0; linha < matrizA.length; linha ++){ 
            for( int coluna = 0; coluna <matrizA.length; coluna ++){
                System.out.print( matrizA[linha][coluna] + "  ") ;
            }
            System.out.println(""); 
        }
    }
}
