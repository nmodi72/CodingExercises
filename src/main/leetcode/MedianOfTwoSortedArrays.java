package main.leetcode;

/**
 * This is Leetcode problem # 4
 * Median of Two Sorted Arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:	nums1 = [1, 3]	nums2 = [2]
 * The median is 2.0
 *
 * Example 2:	nums1 = [1, 2]	nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    // 73 ms - 25.94% beat otehrs
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arraySize = nums1.length + nums2.length;
        int[] resultArray = new int[arraySize];
        if(arraySize <= 0)  return 0.0;
        int indexArray1 = 0;
        int indexArray2 = 0;
        for(int i = 0; i < arraySize; i ++) {
            if(indexArray1 < nums1.length && indexArray2 < nums2.length) {
                if(nums1[indexArray1] < nums2[indexArray2]) {
                    resultArray[i] =  nums1[indexArray1];
                    indexArray1++;
                } else {
                    resultArray[i] =  nums2[indexArray2];
                    indexArray2++;
                }
            } else if(indexArray1 < nums1.length) {
                resultArray[i] =  nums1[indexArray1];
                indexArray1++;
            } else  if(indexArray2 < nums2.length) {
                resultArray[i] =  nums2[indexArray2];
                indexArray2++;
            }
            if(i == (arraySize / 2)) {
                if(arraySize % 2 == 0) {
                    return (double) (resultArray[i] +resultArray[i-1]) / 2;
                } else {
                    return (double) resultArray[i];
                }
            }
        }
        return 0;
    }

    // 68ms - 53.41% beat others
    public double findMedianSortedArraysAnotherSolution(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k= 0;
        while(i < nums1.length && j < nums2.length && k <= result.length / 2) {
            if(nums1[i] < nums2[j]) {
                result[k++] =  nums1[i++];
            } else {
                result[k++] =  nums2[j++];
            }
        }
        while (i < nums1.length && k <= result.length / 2) {
            result[k++] =  nums1[i++];
        }
        while (j < nums2.length && k <= result.length / 2) {
            result[k++] =  nums2[j++];
        }

        if(result.length % 2 == 1) {
            return (double) result[result.length/2];
        } else {
            return (double) (result[result.length/2-1] +result[result.length/2]) / 2;
        }
    }
}
