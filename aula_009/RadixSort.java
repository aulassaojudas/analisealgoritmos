public class RadixSort {
   
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; 
        int[] count = new int[10]; 

        // conta os digitos usanso exp (posição) 
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        // conta as ocorrencias 
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // cria o array de saida 
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void radixSort(int[] arr) {
        int m = getMax(arr);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Array original:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        radixSort(arr);

        System.out.println("Array ordenado:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
