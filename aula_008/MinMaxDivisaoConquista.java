package aula_008;

public class MinMaxDivisaoConquista {

    static class ParMinMax {
        int minimo;
        int maximo;

        ParMinMax(int minimo, int maximo) {
            this.minimo = minimo;
            this.maximo = maximo;
        }
    }

    public static void main(String[] args) {
        int[] vetor = {12, 34, 56, 78, 90, 11, 23, 45, 67, 89};
        ParMinMax resultado = encontrarMinMax(vetor, 0, vetor.length - 1);
        System.out.println("Menor elemento: " + resultado.minimo);
        System.out.println("Maior elemento: " + resultado.maximo);
    }

    public static ParMinMax encontrarMinMax(int[] vetor, int inicio, int fim) {
        if (inicio == fim) { // Se o vetor tem um só elemento termina
            return new ParMinMax(vetor[inicio], vetor[inicio]);
        }

        if (fim == inicio + 1) { // Se o vetor tem dois elementos termina
            if (vetor[inicio] < vetor[fim]) {
                return new ParMinMax(vetor[inicio], vetor[fim]);
            } else {
                return new ParMinMax(vetor[fim], vetor[inicio]);
            }
        }

        // Dividir o vetor em duas partes
        int meio = (inicio + fim) / 2;
        ParMinMax resultadoEsquerda = encontrarMinMax(vetor, inicio, meio);
        ParMinMax resultadoDireita = encontrarMinMax(vetor, meio + 1, fim);

        // Conquistar: combinar os resultados
        return new ParMinMax(
            Math.min(resultadoEsquerda.minimo, resultadoDireita.minimo),
            Math.max(resultadoEsquerda.maximo, resultadoDireita.maximo)
        );
    }
}
