// Classe que representa um nó da lista duplamente encadeada
class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    // Construtor para criar um novo nó
    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Classe que representa a lista duplamente encadeada
class DoublyLinkedList {
    private DoublyNode head;

    // Construtor para criar uma lista duplamente encadeada vazia
    public DoublyLinkedList() {
        this.head = null;
    }

    // Método para adicionar um elemento no final da lista
    public void add(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Método para imprimir os elementos da lista do início ao fim
    public void printList() {
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Método para imprimir os elementos da lista do fim ao início
    public void printListReverse() {
        if (head == null) return;

        DoublyNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Método para remover o primeiro nó que contém um valor específico
    public void remove(int data) {
        if (head == null) {
            return;
        }

        DoublyNode current = head;

        // Caso o elemento a ser removido seja o primeiro da lista
        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        while (current != null && current.data != data) {
            current = current.next;
        }

        // Se o nó foi encontrado, removê-lo
        if (current != null) {
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
        }
    }
}

// Classe principal para testar a lista duplamente encadeada
public class DoublyLinkedListExample {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Adicionando elementos à lista
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Imprimindo os elementos da lista
        System.out.println("Elementos da lista (do início ao fim):");
        list.printList();  // Saída: 10 20 30 40

        // Imprimindo os elementos da lista em ordem reversa
        System.out.println("Elementos da lista (do fim ao início):");
        list.printListReverse();  // Saída: 40 30 20 10

        // Removendo um elemento da lista
        list.remove(30);

        // Imprimindo a lista após remoção
        System.out.println("Lista após remover o elemento 30 (do início ao fim):");
        list.printList();  // Saída: 10 20 40
    }
}
