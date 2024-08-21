public class ArrayExample {
    public static void main(String[] args) {
        // Declaração e inicialização de um array de inteiros
        int[] numbers = {1, 2, 3, 4, 5};

        // Acessando e imprimindo os elementos do array
        System.out.println("Elementos do array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Elemento " + i + ": " + numbers[i]);
        }

        // Modificando um elemento do array
        numbers[2] = 10;

        // Imprimindo o array modificado
        System.out.println("\nArray após modificação:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Elemento " + i + ": " + numbers[i]);
        }
    }
}
