// Classe que representa um nó da pilha
class StackNode {
    int data;
    StackNode next;

    // Construtor para criar um novo nó
    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Classe que representa a pilha
class Stack {
    private StackNode top;

    // Construtor para criar uma pilha vazia
    public Stack() {
        this.top = null;
    }

    // Método para empilhar (push) um elemento na pilha
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Método para desempilhar (pop) um elemento da pilha
    public int pop() {
        if (top == null) {
            System.out.println("Pilha vazia! Não é possível desempilhar.");
            return -1;
        }

        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Método para visualizar o elemento no topo da pilha
    public int peek() {
        if (top == null) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        return top.data;
    }

    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return top == null;
    }

    // Método para imprimir todos os elementos da pilha
    public void printStack() {
        if (top == null) {
            System.out.println("Pilha vazia!");
            return;
        }

        StackNode current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Classe principal para testar a pilha
public class StackExample {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Empilhando elementos na pilha
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Imprimindo a pilha
        System.out.println("Pilha após empilhar 10, 20, 30:");
        stack.printStack();  // Saída: 30 20 10

        // Visualizando o elemento do topo da pilha
        System.out.println("Elemento no topo da pilha: " + stack.peek());  // Saída: 30

        // Desempilhando um elemento da pilha
        System.out.println("Elemento desempilhado: " + stack.pop());  // Saída: 30

        // Imprimindo a pilha após desempilhar
        System.out.println("Pilha após desempilhar:");
        stack.printStack();  // Saída: 20 10

        // Verificando se a pilha está vazia
        System.out.println("A pilha está vazia? " + stack.isEmpty());  // Saída: false
    }
}

