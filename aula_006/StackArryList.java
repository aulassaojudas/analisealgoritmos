/*
  O código implementa uma pilha (`stack`) utilizando `ArrayList` 
 
### Classe `StackArryList<T>`
- **Atributos**:
  - `elements`: Uma lista do tipo `List<T>` que armazena os elementos da pilha.
  
- **Construtor**:
  - `public StackArryList()`: inicializa `elements` com uma instância de `ArrayList<T>()`. 
  
- **Métodos**:
  - `push(T element)`: Método para adicionar um elemento ao topo da pilha.
  - `pop()`    : Método para remover e retornar o elemento do topo da pilha.
  - `peek()`   : Método para retornar (sem remover) o elemento no topo da pilha.
  - `isEmpty()`: Retorna `true` se a pilha não tiver elemento.
  - `size()`   : Retorna o número de elementos na pilha.
 */
import java.util.ArrayList;
import java.util.List;

public class StackArryList<T> {
    private List<T> elements;

    public StackArryList() {
        this.elements = new ArrayList<>();
    }

    public void push(T element) {
        elements.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        StackArryList<Integer> stack = new StackArryList<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());
        stack.pop();
        System.out.println("Top element is now: " + stack.peek());

        stack.push(40);
        System.out.println("Stack size is: " + stack.size());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
