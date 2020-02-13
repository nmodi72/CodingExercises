package main.java.Impl.selfpractice;

import java.util.Stack;

/**
 * Created by nirmodi on 1/31/17.
 */
public class DecimalToBinary {

    public static int[] convertBinary(int num){
        Stack st = new Stack();
        int index = 0;
        while (num > 0) {
            st.push(num % 2);
            num = num / 2;
        }
        int[] arr = new int[st.size()];
        int ind = 0;
        while (!st.isEmpty()) {
            arr[ind++] = (int) st.pop();
        }
        return arr;
    }

    public static int convertDecimal(int[] arr){
        int result = 0;

        Stack st = new Stack();
        for (int i : arr) {
            st.push(i);
        }
        int id = 0;
        while (!st.isEmpty()) {
            result += ((int) st.pop()) * Math.pow(2, id) ;
            id++;
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println("Result:");
        for (int i: convertBinary(5)) {
            System.out.print(i + " ");
        }
//        int[] arr = {1, 1, 0, 1};
//        System.out.println("Result:" + convertDecimal(arr));
    }
}
