package algo_tests;

import java.util.Arrays;

public class QuickSortPartitioning {
    public static void main(String[] args) {
        quickSortPartitioningLastElAsPivot(new int[]{5, 11, 9, 8, 7, 9});
    }

    public static void quickSortPartitioningLastElAsPivot(int[] arr) {
        int pivot = arr[arr.length - 1];

        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < pivot || j == arr.length - 1) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
