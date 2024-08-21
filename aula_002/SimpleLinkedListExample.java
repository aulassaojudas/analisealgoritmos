// Classe que representa um nó da lista encadeada
class Node {
    int data;
    Node next;

    // Construtor para criar um novo nó
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Classe que representa a lista encadeada
class SimpleLinkedList {
    private Node head;

    // Construtor para criar uma lista encadeada vazia
    public SimpleLinkedList() {
        this.head = null;
    }

    // Método para adicionar um elemento no final da lista
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Método para imprimir todos os elementos da lista
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Método para remover o primeiro nó que contém um valor específico
    public void remove(int data) {
        if (head == null) {
            return;
        }

        // Caso o elemento a ser removido seja o primeiro da lista
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        // Se o nó foi encontrado, removê-lo
        if (current != null) {
            previous.next = current.next;
        }
    }
}

// Classe principal para testar a lista encadeada
public class SimpleLinkedListExample {
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();

        // Adicionando elementos à lista
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Imprimindo os elementos da lista
        System.out.println("Elementos da lista:");
        list.printList();  // Saída: 10 20 30 40

        // Removendo um elemento da lista
        list.remove(30);

        // Imprimindo a lista após remoção
        System.out.println("Lista após remover o elemento 30:");
        list.printList();  // Saída: 10 20 40
    }
}
