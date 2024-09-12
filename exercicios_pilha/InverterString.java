import java.util.Scanner;
import java.util.Stack;

public class InverterString {
    public static String inverter(String str) {
        Stack<Character> pilha = new Stack<>();
        
        // Empilhar os caracteres
        for (char ch : str.toCharArray()) {
            pilha.push(ch);
        }
        
        // Desempilhar e construir a string invertida
        StringBuilder stringInvertida = new StringBuilder();
        while (!pilha.isEmpty()) {
            stringInvertida.append(pilha.pop());
        }
        
        return stringInvertida.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite uma string para inverter:");
        String str = scanner.nextLine();
        
        System.out.println("String invertida: " + inverter(str));
        
        scanner.close();
    }
}
