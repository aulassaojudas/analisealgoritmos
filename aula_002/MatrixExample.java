public class MatrixExample {
    public static void main(String[] args) {
        // Declaração e inicialização de uma matriz 2x3
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Acessando e imprimindo os elementos da matriz
        System.out.println("Elementos da matriz:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Nova linha após cada linha da matriz
        }

        // Modificando um elemento da matriz
        matrix[1][2] = 10;

        // Imprimindo a matriz modificada
        System.out.println("\nMatriz após modificação:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}