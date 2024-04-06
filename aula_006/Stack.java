/*
 O código implementa uma pilha usando um array para armazenar os elementos. 
 
### Atributos da Classe `Stack`

- `arr`     : um array de inteiros que armazena os elementos da pilha.
- `top`     : um índice que aponta para o topo da pilha.
- `capacity`: a capacidade máxima da pilha.

### Métodos

- `push(int x)`: Adiciona um elemento `x` ao topo da pilha. 
- `pop()`      : Remove e retorna o elemento do topo da pilha.
- `peek()`     : Retorna o elemento no topo da pilha sem removê-lo.
- `size()`     : Retorna o número de elementos na pilha, que é `top + 1`.
- `isEmpty()`  : Retorna `true` se a pilha estiver vazia (`top == -1`).
- `isFull()`   : Retorna `true` se a pilha estiver cheia (`top == capacity - 1`).

 */
public class Stack {
    private int[] arr; 
    private int top; 
    private int capacity; 

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            throw new IllegalStateException("Overflow: Cannot add more elements, stack is full");
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Underflow: Cannot remove element, stack is empty");
        }
        return arr[top--];
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("O elemento do topo é: " + stack.peek());
        stack.pop();
        System.out.println("O elemento do topo é: " + stack.peek());

        stack.push(4);

        System.out.println("O tamanho da pilha é: " + stack.size());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}