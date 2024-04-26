package aula_009;

public class MergeSort {

    // Método auxiliar para imprimir o array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método recursivo principal para o Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Encontra o ponto médio
            int m = l + (r - l) / 2;

            // Ordena a primeira e a segunda metades
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Mescla as metades ordenadas
            merge(arr, l, m, r);
        }
    }

    // Mescla duas subseções de arr[]
    public static void merge(int[] arr, int l, int m, int r) {
        // Tamanhos dos dois subarrays a serem mesclados
        int n1 = m - l + 1;
        int n2 = r - m;

        // Arrays temporários
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Índices iniciais do primeiro e segundo subarrays
        int i = 0, j = 0;

        // Índice inicial do subarray mesclado
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de L[], se houver
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de R[], se houver
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {85, 24, 63, 45, 17, 31, 96, 50};
        System.out.println("Array original:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nArray ordenado:");
        printArray(arr);
    }
}
