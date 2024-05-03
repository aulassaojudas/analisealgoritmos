import java.util.PriorityQueue;

public class HeapSortFila {

    public static void heapSort(int[] array) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int value : array) {
            priorityQueue.add(value);
        }

        int index = 0;
        while (!priorityQueue.isEmpty()) {
            array[index++] = priorityQueue.poll();
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 17, 10, 84, 19, 6, 22, 9};

        System.out.println("Array original:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        heapSort(array);

        System.out.println("Array ordenado:");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
