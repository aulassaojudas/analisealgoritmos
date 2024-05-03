import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    public static void insertionSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int key = bucket.get(i);
            int j = i - 1;

            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j = j - 1;
            }
            bucket.set(j + 1, key);
        }
    }

    public static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int bucketCount = arr.length;

        for (int value : arr) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        float interval = ((float) max - min + 1) / bucketCount;

        for (int value : arr) {
            int index = (int) ((value - min) / interval);
            if (index < 0) {
                index = 0;
            } else if (index >= bucketCount) {
                index = bucketCount - 1;
            }
            buckets.get(index).add(value);
        }

        int position = 0;
        for (List<Integer> bucket : buckets) {
            insertionSort(bucket);
            for (int value : bucket) {
                arr[position++] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {88, 70, 90, 2, 100, 299, 45, 55, 2, 100};
        System.out.println("Array original:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        bucketSort(arr);

        System.out.println("Array ordenado:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
