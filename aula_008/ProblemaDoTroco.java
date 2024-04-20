package aula_008;

public class ProblemaDoTroco {

    public static void main(String[] args) {
        // Moedas disponíveis, ordenadas do maior para o menor valor
        int[] moedas = { 100, 50, 25, 10, 5, 1 };
        int quantia = 289; // A quantia que queremos formar com as moedas
        int[] resultado = calcularTroco(moedas, quantia);
        System.out.println("Moedas necessárias para formar R$" + quantia / 100.0 + ":");
        for (int i = 0; i < moedas.length; i++) {
            if (resultado[i] > 0) {
                System.out.println("Moedas de R$" + moedas[i] / 100.0 + ": " + resultado[i]);
            }
        }
    }

    public static int[] calcularTroco(int[] moedas, int quantia) {
        int[] resultado = new int[moedas.length];

        for (int i = 0; i < moedas.length; i++) {
            // Enquanto a quantia atual for maior ou igual à moeda atual, adicione essa
            // moeda ao resultado
            while (quantia >= moedas[i]) {
                quantia -= moedas[i];
                resultado[i]++;
            }
        }
        return resultado;
    }
}
