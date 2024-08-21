// Classe que representa um nó da lista circular
class CircularNode {
    int data;
    CircularNode next;

    // Construtor para criar um novo nó
    public CircularNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Classe que representa a lista circular
class CircularLinkedList {
    private CircularNode last;

    // Construtor para criar uma lista circular vazia
    public CircularLinkedList() {
        this.last = null;
    }

    // Método para adicionar um elemento no final da lista
    public void add(int data) {
        CircularNode newNode = new CircularNode(data);
        if (last == null) {
            last = newNode;
            last.next = last; // Referência circular para o próprio nó
        } else {
            newNode.next = last.next; // Novo nó aponta para o primeiro nó
            last.next = newNode; // Último nó aponta para o novo nó
            last = newNode; // Novo nó se torna o último nó
        }
    }

    // Método para imprimir os elementos da lista
    public void printList() {
        if (last == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        CircularNode first = last.next;
        CircularNode current = first;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != first); // Continua até voltar ao primeiro nó

        System.out.println();
    }

    // Método para remover o primeiro nó que contém um valor específico
    public void remove(int data) {
        if (last == null) {
            return;
        }

        CircularNode current = last.next;
        CircularNode previous = last;

        // Percorrer a lista para encontrar o nó a ser removido
        do {
            if (current.data == data) {
                if (current == last && current.next == last) {
                    // Caso único elemento seja removido
                    last = null;
                } else {
                    if (current == last) {
                        last = previous; // Atualizar o último nó
                    }
                    previous.next = current.next; // Remover o nó
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);
    }
}

// Classe principal para testar a lista circular
public class CircularLinkedListExample {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

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
