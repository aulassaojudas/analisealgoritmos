import java.util.Scanner;
import java.util.Stack;

public class AvaliarRPN {
    public static int avaliarExpressao(String[] tokens) {
        Stack<Integer> pilha = new Stack<>();
        
        for (String token : tokens) {
            if (isOperador(token)) {
                int b = pilha.pop();
                int a = pilha.pop();
                switch (token) {
                    case "+":
                        pilha.push(a + b);
                        break;
                    case "-":
                        pilha.push(a - b);
                        break;
                    case "*":
                        pilha.push(a * b);
                        break;
                    case "/":
                        pilha.push(a / b);
                        break;
                }
            } else {
                pilha.push(Integer.parseInt(token));
            }
        }
        
        return pilha.pop();
    }

    private static boolean isOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite a expressão em notação pós-fixada (separada por espaços):");
        String expressao = scanner.nextLine();
        String[] tokens = expressao.split(" ");
        
        System.out.println("Resultado: " + avaliarExpressao(tokens));
        
        scanner.close();
    }
}
