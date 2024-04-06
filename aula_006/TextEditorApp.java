/*
O código é uma aplicação de editor de texto simples, 
### Classe `TextEditor`

Esta classe é responsável por gerenciar o texto em um editor, 
com as operações adicionar, deletar texto e desfazer a última alteração.

- **Atributos**:
  - `currentText`: um objeto `StringBuilder` que mantém o texto atual no editor.
  - `history`: uma pilha (`Stack`) que armazena o estado anterior do texto cada vez que 
  uma alteração é feita.

- **Construtor**:
  - Inicializa `currentText` e `history`.

- **Métodos**:
  - `addText(String text)`: adiciona texto ao `currentText`. Salvando o estado atual do texto na pilha `history`.
  - `deleteText(int length)`: remove o último `length` número de caracteres de `currentText`.
  - `undo()`: desfaz a última alteração recuperando o estado mais recente do texto da `history`.
  - `getText()`: retorna o texto atual como uma string.

### Classe `Stack<T>`
Implementa uma pilha generica com as operações

- **Métodos**:
  - `push(T element)`: adiciona um elemento ao topo da pilha.
  - `pop()`: remove e retorna o elemento do topo da pilha. Lança uma exceção se a pilha estiver vazia.
  - `peek()`: retorna o elemento do topo sem removê-lo. Lança uma exceção se a pilha estiver vazia.
  - `isEmpty()`: retorna `true` se a pilha estiver vazia.
  - `size()`: retorna o número de elementos na pilha.

 */
public class TextEditorApp {

    static class Stack<T> {
        private java.util.ArrayList<T> elements = new java.util.ArrayList<>();

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
    }

    static class TextEditor {
        private StringBuilder currentText;
        private Stack<String> history;

        public TextEditor() {
            this.currentText = new StringBuilder();
            this.history = new Stack<>();
        }

        public void addText(String text) {
            history.push(currentText.toString());
            currentText.append(text);
        }

        public void deleteText(int length) {
            history.push(currentText.toString());
            int start = currentText.length() - length;
            if (start < 0)
                start = 0;
            currentText.delete(start, currentText.length());
        }

        public void undo() {
            if (!history.isEmpty()) {
                currentText = new StringBuilder(history.pop());
            }
        }

        public String getText() {
            return currentText.toString();
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        try {
            editor.addText("Ola");
            editor.addText(", mundo!");
            System.out.println("Texto atual: " + editor.getText());

            editor.deleteText(7);
            System.out.println("Texto depois da exclusão: " + editor.getText());

            editor.undo();
            System.out.println("Texto recuperado: " + editor.getText());

            editor.undo();
            System.out.println("Texto recuperado: " + editor.getText());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
