/*
 *
 * Esse programa mostra o conceito de recursão, uma técnica onde uma função chama a si
 * dividindo um problema em subproblemas menores até que um caso
 * base simples possa ser resolvido diretamente.
 * 
 */
public class Fatorial {
    public static int calcularFatorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * calcularFatorial(numero - 1);
        }
    }
    public static void main(String[] args) {
        int numero = 5;
        int resultado = calcularFatorial(numero);
        System.out.println("O fatorial de " + numero + " é " + resultado);
    }
}
