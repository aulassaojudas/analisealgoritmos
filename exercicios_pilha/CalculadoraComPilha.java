import java.util.Scanner;
import java.util.Stack;

public class CalculadoraComPilha {

    // Função para retornar a precedência do operador
    public static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Função para realizar a operação entre dois operandos
    public static int aplicarOperador(char operador, int b, int a) {
        switch (operador) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Divisão por zero");
                return a / b;
        }
        return 0;
    }

    public static int avaliarExpressao(String expressao) {
        Stack<Integer> operandos = new Stack<>();
        Stack<Character> operadores = new Stack<>();
        
        for (int i = 0; i < expressao.length(); i++) {
            char ch = expressao.charAt(i);

            // Ignorar espaços em branco
            if (ch == ' ') {
                continue;
            }

            // Se o caractere for um número, construa o número completo e adicione à pilha de operandos
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expressao.length() && Character.isDigit(expressao.charAt(i))) {
                    num = num * 10 + (expressao.charAt(i) - '0');
                    i++;
                }
                i--; // Corrigir o índice após o loop
                operandos.push(num);
            }
            // Se for um operador, trate-o
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(ch)) {
                    int b = operandos.pop();
                    int a = operandos.pop();
                    char operador = operadores.pop();
                    operandos.push(aplicarOperador(operador, b, a));
                }
                operadores.push(ch);
            }
        }

        // Processar os operadores restantes
        while (!operadores.isEmpty()) {
            int b = operandos.pop();
            int a = operandos.pop();
            char operador = operadores.pop();
            operandos.push(aplicarOperador(operador, b, a));
        }

        // O resultado final será o único valor na pilha de operandos
        return operandos.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite uma expressão aritmética (ex: 5+3*12):");
        String expressao = scanner.nextLine();
        
        try {
            int resultado = avaliarExpressao(expressao);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Erro ao avaliar a expressão: " + e.getMessage());
        }
        
        scanner.close();
    }
}

