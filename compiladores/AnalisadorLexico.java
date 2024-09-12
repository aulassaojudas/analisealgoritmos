import java.util.Scanner;

public class AnalisadorLexico {
    private static final int SIZE = 7;
    private static final int[] cant = {5, 2, 1, 8, 1, 2, 6};
    private static int[] ptros = new int[SIZE];
    private static final char[] crteres = {
        'D', '+', '-', '(', '$', 'D', '(', 'D', 'D', '.', '+', '-', '*', '/', ')', '$', 
        'D', 'D', '(', '+', '-', '*', '/', ')', '$'
    };
    private static final int[] eestados = {
        3, 2, 2, 1, 7, 3, 1, 3, 3, 4, 5, 5, 5, 5, 6, 7, 
        3, 3, 1, 5, 5, 5, 5, 6, 7
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira a expressão aritmética: ");
        String conta = scanner.nextLine() + "$";
        
        llenarPtros();
        int estado = 0;

        for (char crter : conta.toCharArray()) {
            System.out.println("estado:" + estado + " crter:" + crter);
            estado = getEestado(estado, crter);
            if (estado == 'E' || estado == 7) break;
        }

        switch (estado) {
            case 'E':
                System.out.println("Existe um erro léxico");
                break;
            case 7:
                System.out.println("A expressão está formulada corretamente");
                break;
            default:
                System.out.println("ops...");
                break;
        }
        
        scanner.close();
    }

    private static void llenarPtros() {
        int acum = 0;
        for (int i = 0; i < SIZE; i++) {
            ptros[i] = acum;
            acum += cant[i];
        }
    }

    private static int getEestado(int estado, char crter) {
        char valor = Character.isDigit(crter) ? 'D' : crter;
        int max = cant[estado];
        int posic = ptros[estado];
        char resp = 'E';

        for (int i = 0; i < max; i++) {
            if (crteres[posic] == valor) {
                resp = (char) eestados[posic];
                break;
            } else {
                posic++;
            }
        }
        return resp;
    }
}
