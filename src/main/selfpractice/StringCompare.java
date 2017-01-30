package main.selfpractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by nirmodi on 1/29/17.
 */
public class StringCompare {
    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        Integer val = sc.nextInt();
//        Stack stack = new Stack();
//
//        for(int i=0; i< str.length(); i++){
//            if(i+val <= str.length()) {
//                stack.push(str.substring(i, i+val));
//            }
//        }
//        String[] arr = new String[stack.size()];
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = (String) stack.pop();
//        }
//
//        Arrays.sort(arr, new Comparator<String>(){
//            public int compare(String s1, String s2){
//                return s1.compareTo(s2);
//            }
//        });
//        System.out.println(arr[arr.length - 1]);
        System.out.println(counting("00110"));


    }


    static int counting(String s) {

        int count = 0;
        int zeroCount = 0;
        int onesCount = 0;
        boolean prevIsZero = false;
        for(int i = 0; i < s.length(); i++){
            if(prevIsZero) {
                if(s.charAt(i) == '0') {
                    zeroCount++;
                } else {

                }
            } else {

            }

        }
        return count;

    }

}
