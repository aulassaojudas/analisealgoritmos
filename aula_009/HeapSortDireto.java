public class HeapSortDireto {

    public static void heapSort(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--)
            heapify(array, i, array.length - 1);

        for (int i = array.length - 1; i > 0; i--) {
            swapKeys(array, 0, i);
            heapify(array, 0, i - 1);
        }
    }

    private static void heapify(int[] array, int i, int m) {
        int j;
        while (2 * i + 1 <= m) {
            j = 2 * i + 1;
            if (j < m && array[j] < array[j + 1])
                j++;
            if (array[i] < array[j]) {
                swapKeys(array, i, j);
                i = j;
            } else {
                break;
            }
        }
    }

    private static void swapKeys(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {22, 13, 17, 11, 10, 14, 15, 12};

        System.out.println("Array antes da ordenação:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        heapSort(array);

        System.out.println("Array após a ordenação:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

