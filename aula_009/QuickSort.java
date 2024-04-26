package aula_009;

public class QuickSort {

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Recursivamente ordena os elementos antes e depois da partição
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    
    public static void main(String[] args) {
        int[] arr = {85, 24, 63, 45, 17, 31, 96, 50};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Array ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
