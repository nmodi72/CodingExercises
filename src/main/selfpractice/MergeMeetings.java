package main.selfpractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Nirav.Modi on 4/28/2017.
 */
public class MergeMeetings {

    public static HashMap mergeMeetings(Integer[][] arr){
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        HashMap<Integer, Integer> result = new HashMap<>();
        int startTime = arr[0][0];
        int endTime = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i][0] <= endTime){
                startTime = Math.min(startTime, arr[i][0]);
                endTime = Math.max(endTime, arr[i][1]);
            } else {
                result.put(startTime, endTime);
                if(i < arr.length - 1){
                    startTime = arr[i][0];
                    endTime = arr[i][1];
                }
            }
        }
        result.put(startTime, endTime);
        return result;
    }
    public static void main(String[] args){
        Integer[][] arr = {{1, 2},
                           {5, 8},
                           {4, 9},
                           {1, 3},
                           {7, 10},
                           {5, 12}};
        HashMap result = MergeMeetings.mergeMeetings(arr);
    }
}
