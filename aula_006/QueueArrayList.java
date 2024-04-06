/*
 *O código é uma implementação simples de uma fila usando a classe `ArrayList`

### Classe `QueueArrayList`
#### Atributos
- `queue`: Uma lista do tipo `List<Integer>` que armazena os elementos da fila.

#### Construtor
- `QueueArrayList()`: Inicializa a fila criando uma instância de `ArrayList`. 

#### Métodos
- `enqueue(int item)`: Adiciona um elemento ao final da fila.
- `dequeue()`        : Remove e retorna o elemento do início da fila. 
- `isEmpty()`        : Retorna `true` se a fila não tiver elementos.
- `peek()`           : Retorna o primeiro elemento da fila sem removê-lo.
- `display()`        : Imprime todos os elementos da fila.

 */
import java.util.ArrayList;
import java.util.List;

public class QueueArrayList {
    private List<Integer> queue;

    // Construtor
    public QueueArrayList() {
        queue = new ArrayList<>();
    }

    public void enqueue(int item) {
        queue.add(item);
        System.out.println("Elemento adicionado: " + item);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia! Não é possível remover.");
            return -1;
        }
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("A fila está vazia! Não é possível visualizar o primeiro elemento.");
            return -1;
        }
        return queue.get(0);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("A fila está vazia!");
        } else {
            System.out.print("Elementos da fila: ");
            for (int num : queue) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueArrayList queue = new QueueArrayList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Elemento removido: " + queue.dequeue());
        System.out.println("Elemento removido: " + queue.dequeue());

        queue.display();

        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();

        System.out.println("Primeiro elemento: " + queue.peek());
    }
}
