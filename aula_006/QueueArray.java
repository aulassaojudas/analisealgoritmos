/*
 O código implementa uma fila utilizando um array.

### Atributos da Classe `QueueArray`

- `queue`   : Um array de inteiros que armazena os elementos da fila.
- `front`   : Um índice que aponta para o primeiro elemento da fila.
- `rear`    : Um índice que aponta para a última posição ocupada na fila.
- `capacity`: A capacidade total da fila, definida no momento da criação da instância.
- `count`   : Conta o número de elementos atualmente na fila.

### Construtor
- `QueueArray(int size)`: Inicializa a fila com uma capacidade específica (`size`).

### Métodos
- `enqueue(int item)`: Adiciona um item ao final da fila. 
- `dequeue()`        : Remove e retorna o elemento da frente da fila. 
- `isFull()`         : Verifica se a fila está cheia comparando `count` com `capacity`.  
- `isEmpty()`        : Verifica se a fila está vazia checando se `count` é 0.
- `peek()`           : Retorna o elemento na frente da fila sem removê-lo.
- `display()`        : Imprime todos os elementos da fila.

 */
public class QueueArray {
    private int[] queue;
    private int front;  
    private int rear;   
    private int capacity;
    private int count;
    
    public QueueArray(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Fila cheia, não é possível colocar mais elementos");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
        System.out.println("Elemento inserido " + item);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia, não é possível remover mais elementos");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Fila vazia, não há elementos para exibir");
            return -1;
        }
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
            return;
        }
        System.out.print("Os elementos da fila são: ");
        for (int i = 0; i < count; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.display();

        queue.dequeue();
        queue.dequeue();

        queue.display();

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        queue.display();
        queue.enqueue(8);
    }
}

