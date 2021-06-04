package main.java.Impl.InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class FacebookInterviewQuestion {



    public static int[] sortArray(int[] arr) {
        if (arr.length == 0) return arr;
        int partitionCount = 1;
        Map<Integer, Integer> data = new HashMap<>();
        data.put(0,0);
        int prevIndex = 0;
        for (int i=1; i < arr.length; i++) {
            if(arr[i-1] > arr[i]) {
                partitionCount++;
                data.put(prevIndex, i-1);
                prevIndex = i;
                data.put(prevIndex, i);
            }
        }
        data.put(prevIndex, arr.length-1);
        Map<Integer, Integer> indexMap = reconcileItemPointersMap(data, partitionCount);

        // if still there's only one key then return array as it is!
        if (indexMap.size() == 1) return arr;

        // now let's make calculate result array
        int i = 1;
        int j = 2;
        while(indexMap.size() > 1) {
            int start1 = indexMap.get(i);
            int end2 = data.get(indexMap.get(j));
            int[] subResult = mergeArrays(arr, start1, data.get(indexMap.get(i)), indexMap.get(j), end2);

            int subResultId = 0;
            for (int a = start1; a <= end2; a++) {
                arr[a] = subResult[subResultId++];
            }
            data.put(indexMap.get(i), end2);
            data.remove(indexMap.get(j));
            partitionCount--;
            indexMap = reconcileItemPointersMap(data, partitionCount);
        }
        return arr;
    }

    private static Map<Integer, Integer> reconcileItemPointersMap(Map<Integer, Integer> data, int partitionCount){
        Map<Integer, Integer> indexMap = new HashMap<>();
        int id = partitionCount;
        for (Map.Entry mapElement : data.entrySet()) {
            indexMap.put(partitionCount-id+1, (Integer)mapElement.getKey());
            id--;
        }
        return indexMap;
    }

    private static int[] mergeArrays(int[] arr, int start1, int end1, int start2, int end2) {
        int[] result = new int[(end2 - start1)+ 1];
        int pt = 0;
        while(start1 <= end1 && start2 <= end2) {
            if(arr[start1] < arr[start2]) {
                result[pt++] = arr[start1++];
            } else {
                result[pt++] = arr[start2++];
            }
        }
        while(start1 <= end1) {
            result[pt++] = arr[start1++];
        }
        while(start2 <= end2) {
            result[pt++] = arr[start2++];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] input = {1,3,5,2,4,10,20,30,11,15,18};


        int[] result = sortArray(input);
        for (int i : result) {
            System.out.println(i);
        }

    }

}
