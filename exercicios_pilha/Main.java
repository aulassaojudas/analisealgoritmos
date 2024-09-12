import java.util.Scanner;
import java.util.Stack;

// Classe que representa a calculadora
class Calculadora {
    private Stack<Integer> operandos;  // Pilha de operandos (números)
    private Stack<Character> operadores;  // Pilha de operadores (+, -, *, /)

    public Calculadora() {
        operandos = new Stack<>();
        operadores = new Stack<>();
    }

    // Função principal para avaliar a expressão
    public int avaliarExpressao(String expressao) {
        for (int i = 0; i < expressao.length(); i++) {
            char ch = expressao.charAt(i);

            // Ignorar espaços
            if (ch == ' ') {
                continue;
            }

            // Se o caractere for um número, empilhe-o como operando
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expressao.length() && Character.isDigit(expressao.charAt(i))) {
                    num = num * 10 + (expressao.charAt(i) - '0');
                    i++;
                }
                i--;  // Corrigir o índice após sair do loop
                operandos.push(num);
            }
            // Se o caractere for um operador, processá-lo
            else if (Operador.isOperador(ch)) {
                while (!operadores.isEmpty() && Operador.precedencia(operadores.peek()) >= Operador.precedencia(ch)) {
                    executarOperacao();
                }
                operadores.push(ch);
            }
        }

        // Processar todos os operadores restantes
        while (!operadores.isEmpty()) {
            executarOperacao();
        }

        // O resultado final será o único valor na pilha de operandos
        return operandos.pop();
    }

    // Função para executar a operação no topo da pilha de operadores
    private void executarOperacao() {
        int b = operandos.pop();
        int a = operandos.pop();
        char operador = operadores.pop();
        int resultado = Operacao.aplicarOperador(operador, a, b);
        operandos.push(resultado);
    }
}

// Classe que contém a lógica dos operadores
class Operador {
    // Função para verificar se um caractere é um operador
    public static boolean isOperador(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Função que retorna a precedência do operador
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
}

// Classe que contém a lógica para realizar operações aritméticas
class Operacao {
    // Aplica o operador nos dois operandos e retorna o resultado
    public static int aplicarOperador(char operador, int a, int b) {
        switch (operador) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Divisão por zero");
                }
                return a / b;
            default:
                throw new UnsupportedOperationException("Operador inválido");
        }
    }
}

// Classe principal que executa o programa
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma expressão aritmética (ex: 5+3*12):");
        String expressao = scanner.nextLine();

        // Instancia a calculadora e avalia a expressão
        Calculadora calculadora = new Calculadora();
        try {
            int resultado = calculadora.avaliarExpressao(expressao);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }
}
