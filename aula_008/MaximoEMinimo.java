package aula_008;

public class MaximoEMinimo {
    public static int[] encontrarMaximoEMinimo(int[] numeros) {
        int minimo = numeros[0];
        int maximo = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < minimo) {
                minimo = numeros[i];
            }
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }
        return new int[]{minimo, maximo};
    }
    public static void main(String[] args) {
        int[] numeros = {34, 7, 23, 32, 99, 4, 18, 82, 12, 58};
        int[] resultado = encontrarMaximoEMinimo(numeros);
        System.out.println("Mínimo: " + resultado[0]);
        System.out.println("Máximo: " + resultado[1]);
    }
}
