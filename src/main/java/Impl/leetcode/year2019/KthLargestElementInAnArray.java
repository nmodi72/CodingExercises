package main.java.Impl.leetcode.year2019;

public class KthLargestElementInAnArray {

    /*
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        // output
        return heap.poll();
  }

    */

    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length-1, nums.length-k);
    }

    int quickselect(int[] nums, int low, int high, int k) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++){
            if(nums[j] <= pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, high);
        if (i == k) return nums[i];
        if (i > k) return quickselect(nums, low, i-1, k);
        if (i < k) return quickselect(nums, i+1, high, k);

        return -1;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
