
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            /* Mova os elementos do array que são maiores que o elemento
               atual para uma posição à frente de sua posição atual */
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Coloque o elemento atual na posição correta
            arr[j + 1] = current;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6}; 
        insertionSort(arr);
        System.out.println("Array ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
