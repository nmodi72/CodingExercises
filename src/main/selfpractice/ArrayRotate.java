package main.selfpractice;

/**
 * http://www.geeksforgeeks.org/array-rotation/
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
 *
 */
public class ArrayRotate {

    public static int[] rightRotate(int arr[], int d, int n) {
        if(arr.length < n) {
            return arr;
        }
        if(d > n) {
            d = d % n;
        }
        int tempPosition = 0;
        int[] result = new int[arr.length];
        for(int i = 0; i < n; i++) {
            tempPosition = i + d;
            if(tempPosition >= n) {
                tempPosition = tempPosition - n;
            }
            result[tempPosition] = arr[i];
        }
        if(n < arr.length) {
            for (int i = n; i <arr.length; i++) {
                result[i] = arr[i];
            }
        }
        return result;
    }

    public static int[] leftRotate(int arr[], int d, int n) {
        int[] tempArray = new int[arr.length];
        int tempPosition = 0;
        for(int i = 0; i < n; i++) {
            tempPosition = (n - d) + i;
            if(tempPosition >= n) {
                tempPosition = tempPosition % n;
            }
            tempArray[tempPosition] = arr[i];
        }
        if((arr.length - n) > 0) {
            for (int i = n; i < arr.length; i++) {
                tempArray[i] = arr[i];
            }
        }
        return tempArray;
    }

    public static int[] leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        int[] result = new int[arr.length];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
        return arr;
    }

    public static boolean isPalindrome (String str) {
        if(str == null) {
            return false;
        } else if(str.length() <= 1) {
            return true;
        }
        return (str.charAt(0) == str.charAt(str.length() -1)) && isPalindrome(str.substring(1, str.length() - 1));
    }

    public static void main(String args[]) throws Exception {
        System.out.print("Result:" + isPalindrome("PPAAPP"));
    }
}
