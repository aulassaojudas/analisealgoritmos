import java.util.HashMap;
import java.util.Map;

public class Automato {
    private static final int NUM_ESTADOS = 6;
    private static final int NUM_SIMBOLOS = 5;
    private static final int[][] transicoes = new int[NUM_ESTADOS][NUM_SIMBOLOS];
    private static final Map<Character, Integer> simboloParaIndice = new HashMap<>();
    private static final int[] estadosAceite = {4, 5};

    static {
        simboloParaIndice.put('B', 0);
        simboloParaIndice.put('C', 1);
        simboloParaIndice.put('D', 2);
        simboloParaIndice.put('E', 3);
        simboloParaIndice.put('F', 4);

        transicoes[0][simboloParaIndice.get('B')] = 1;
        transicoes[1][simboloParaIndice.get('C')] = 2;
        transicoes[1][simboloParaIndice.get('D')] = 3;
        transicoes[2][simboloParaIndice.get('E')] = 4;
        transicoes[3][simboloParaIndice.get('F')] = 5;
    }

    public static boolean processar(String entrada) {
        int estadoAtual = 0;

        for (char simbolo : entrada.toCharArray()) {
            if (simboloParaIndice.containsKey(simbolo)) {
                int indiceSimbolo = simboloParaIndice.get(simbolo);
                estadoAtual = transicoes[estadoAtual][indiceSimbolo];
            } else {
                return false;
            }
        }

        for (int estado : estadosAceite) {
            if (estadoAtual == estado) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] entradas = {"BCE", "BDF", "BD", "BCF"};
        for (String entrada : entradas) {
            if (processar(entrada)) {
                System.out.println("Entrada " + entrada + " aceita.");
            } else {
                System.out.println("Entrada " + entrada + " rejeitada.");
            }
        }
    }
}
