import java.util.Scanner;
import java.util.Stack;

public class VerificarParenteses {
    public static boolean verificarParentesesBalanceados(String expressao) {
        Stack<Character> pilha = new Stack<>();
        
        for (char ch : expressao.toCharArray()) {
            if (ch == '(') {
                pilha.push(ch);
            } else if (ch == ')') {
                if (pilha.isEmpty()) {
                    return false; // Fechamento de parênteses sem abertura correspondente
                }
                pilha.pop();
            }
        }
        
        return pilha.isEmpty(); // Se a pilha está vazia, está balanceado
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite uma expressão com parênteses:");
        String expressao = scanner.nextLine();
        
        if (verificarParentesesBalanceados(expressao)) {
            System.out.println("Parênteses balanceados");
        } else {
            System.out.println("Parênteses não balanceados");
        }
        
        scanner.close();
    }
}
