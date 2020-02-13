package main.java.Impl.selfpractice;

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

    public static boolean isPalindrome1 (String str) {
        if(str == null) {
            return false;
        } else if(str.length() <= 1) {
            return true;
        }
        return (str.charAt(0) == str.charAt(str.length() -1)) && isPalindrome1(str.substring(1, str.length() - 1));
    }

    public static int[] arrayRotate(int[] arr, int d){
        if(arr.length < d) {
            d = d % arr.length;
        }
        int id = 0;
        int[] result = new int[arr.length];
        for (int i = d; i < arr.length; i++){
            result[id] = arr[i];
            id++;
        }
        for (int i = 0; i < d; i++){
            result[id] = arr[i];
            id++;
        }
        return result;
    }

    public static String reverseString(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void printFiboncci(int n){

       for(int i = 0; i <= n; i++){

       }
    }

    public static int isFibonnaci(int n){
        if(n == 1 || n == 2)
            return 1;
        return isFibonnaci(n - 1) + isFibonnaci(n - 2);
    }

    public boolean isPalindrome(String str){
        if(str == null)
            return false;
        if(str.length() == 0 || str.length() == 1)
            return true;
        return (str.charAt(0) == str.charAt(str.length() - 1)) && isPalindrome(str.substring(0, str.length() - 1));
    }
    public static boolean isArmstrongNumber(int num){
        int size = String.valueOf(num).length();
        int sum = 0;
        int temp = num;
        while(temp > 0) {
            sum += (int) Math.pow(temp % 10, size);
            temp /= 10;
        }
        return (sum == num);
    }
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++){
                String a = prefix + str.charAt(i);
                String b = str.substring(0, i) + str.substring(i+1, n);
                permutation(a, b);
            }

        }
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
    public static void main(String args[]) throws Exception {
        String s = longestPalindrome("abcdcdjhsd");
    }
}
