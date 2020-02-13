package main.java.Impl.leetcode.year2019;

public class QuickSort {

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot-1);
            sort(arr, pivot+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++){
            if (arr[j] < pivot) {
                    i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp2 = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp2;
        return i+1;
    }

}


