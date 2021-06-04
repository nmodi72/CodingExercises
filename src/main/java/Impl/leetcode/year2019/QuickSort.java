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
        int left = low;
        for (int j = low; j < high; j++){
            if (arr[j] < pivot) {
                swap(arr, left++, j);
            }
        }
        swap(arr, left, high);
        return left;
    }
    static void swap(int a[],int i,int j){
        int tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    /*
    Another method to sort
     */
    void quickSort(int a[], int low, int high){
        int i=low,j=high;   //                        3 2 1 5 6 4    pivot = 1
        //int pivot=a[high];
        int pivot = a[low + (high-low)/2];
        while(i<=j){
            while(a[i] < pivot) i++;
            while(a[j] > pivot) j--;
            if(i<=j) {
                swap(a,i,j);    // 1 2 3 5 6 4
                i++;
                j--;
            }
        }
        if(low< j) quickSort(a,low,j);
        if(i<high) quickSort(a,i,high);
    }


    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        sort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}


